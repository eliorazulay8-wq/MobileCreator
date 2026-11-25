# MobileCreator

MobileCreator is an Android-first visual workspace for creating Minecraft Java mod projects.

## Current status

This repository contains an early Android app shell and a GitHub Actions APK build. It is **not a complete MCreator replacement yet**. The current app has a basic Compose workspace screen; editor cards and several tabs are placeholders. It does not yet generate or compile Minecraft Forge mods.

## Build an APK on GitHub

1. Open the **Actions** tab in this repository.
2. Select **Build MobileCreator APK**.
3. Tap **Run workflow** on the `main` branch.
4. Wait for the workflow to finish successfully.
5. Open the completed run and download the `MobileCreator-debug-apk` artifact.
6. Extract the ZIP and install `app-debug.apk` on your Android device.

A push to `main` also starts an APK build automatically.

## Target

- Android phones (minimum Android 8.0 / API 26)
- Minecraft Java mod authoring
- Initial target loader: Minecraft Forge 1.20.1
- Kotlin and Jetpack Compose

## Planned development

1. Workspace and persistent project management
2. Functional item, block, tool, armor and recipe editors
3. Pixel texture editor and 3D model editor
4. Visual procedures and event system
5. Mob, GUI, dimension and biome editors
6. Forge source generation, build validation and JAR export
7. Import/export and project backup

The desktop MCreator source archive is not an Android project and has not been directly converted into this app. Android-specific implementations are required for the planned features.
