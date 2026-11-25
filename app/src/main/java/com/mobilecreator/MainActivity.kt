package com.mobilecreator

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Extension
import androidx.compose.material.icons.filled.Inventory2
import androidx.compose.material.icons.filled.Palette
import androidx.compose.material.icons.filled.Schema
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent { MobileCreatorApp() }
    }
}

private data class EditorTool(
    val title: String,
    val subtitle: String,
    val icon: ImageVector
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun MobileCreatorApp() {
    var selectedTab by remember { mutableIntStateOf(0) }
    val tools = listOf(
        EditorTool("Items", "Create food, tools and objects", Icons.Default.Inventory2),
        EditorTool("Blocks", "Design custom blocks", Icons.Default.Extension),
        EditorTool("Textures", "Pixel-art texture workspace", Icons.Default.Palette),
        EditorTool("Procedures", "Build logic with visual nodes", Icons.Default.Schema),
        EditorTool("Mod settings", "Forge 1.20.1 project details", Icons.Default.Settings)
    )

    MaterialTheme {
        Scaffold(
            topBar = {
                TopAppBar(title = {
                    Column {
                        Text("MobileCreator")
                        Text(
                            "Minecraft Forge 1.20.1",
                            style = MaterialTheme.typography.labelMedium,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }
                })
            },
            bottomBar = {
                NavigationBar {
                    NavigationBarItem(
                        selected = selectedTab == 0,
                        onClick = { selectedTab = 0 },
                        icon = { Icon(Icons.Default.Inventory2, contentDescription = null) },
                        label = { Text("Workspace") }
                    )
                    NavigationBarItem(
                        selected = selectedTab == 1,
                        onClick = { selectedTab = 1 },
                        icon = { Icon(Icons.Default.Schema, contentDescription = null) },
                        label = { Text("Logic") }
                    )
                    NavigationBarItem(
                        selected = selectedTab == 2,
                        onClick = { selectedTab = 2 },
                        icon = { Icon(Icons.Default.Settings, contentDescription = null) },
                        label = { Text("Settings") }
                    )
                }
            }
        ) { padding ->
            when (selectedTab) {
                0 -> WorkspaceScreen(tools, Modifier.padding(padding))
                1 -> PlaceholderScreen("Visual procedures", "The node-based procedure editor will be built here.")
                else -> PlaceholderScreen("Project settings", "Configure the mod name, mod ID, package and Minecraft Forge version.")
            }
        }
    }
}

@Composable
private fun WorkspaceScreen(tools: List<EditorTool>, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.fillMaxSize().padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Surface(
            shape = RoundedCornerShape(20.dp),
            color = MaterialTheme.colorScheme.primaryContainer,
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(Modifier.padding(18.dp)) {
                Text("Your mod workspace", style = MaterialTheme.typography.headlineSmall)
                Spacer(Modifier.height(6.dp))
                Text("Create Minecraft content visually, right from your phone.")
                Spacer(Modifier.height(10.dp))
                Text("PROJECT: New Mod  •  TARGET: Forge 1.20.1", style = MaterialTheme.typography.labelMedium)
            }
        }
        Text("Create something", style = MaterialTheme.typography.titleLarge)
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            contentPadding = PaddingValues(bottom = 20.dp),
            horizontalArrangement = Arrangement.spacedBy(12.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(tools) { tool ->
                Card(
                    modifier = Modifier.fillMaxWidth().height(142.dp).clickable { },
                    colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceContainer)
                ) {
                    Column(
                        Modifier.fillMaxSize().padding(14.dp),
                        verticalArrangement = Arrangement.SpaceBetween
                    ) {
                        Icon(tool.icon, contentDescription = null, tint = MaterialTheme.colorScheme.primary)
                        Column {
                            Text(tool.title, style = MaterialTheme.typography.titleMedium)
                            Text(tool.subtitle, style = MaterialTheme.typography.bodySmall,
                                color = MaterialTheme.colorScheme.onSurfaceVariant)
                        }
                    }
                }
            }
        }
    }
}

@Composable
private fun PlaceholderScreen(title: String, description: String) {
    Column(
        Modifier.fillMaxSize().padding(24.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(title, style = MaterialTheme.typography.headlineMedium)
        Spacer(Modifier.height(10.dp))
        Text(description, style = MaterialTheme.typography.bodyLarge)
    }
}
