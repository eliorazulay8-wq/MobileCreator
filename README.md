# MobileCreator

MobileCreator is an Android-first visual workspace for creating Minecraft Java Forge 1.20.1 mod projects.

## Current stage
This repository starts the Android application and its first editor shell. It is **not yet a complete MCreator replacement** and does not currently compile or export Forge mods. The initial milestone is a usable mobile UI and project model; later milestones add block/item editors, textures, visual procedures, and a Forge project generator/build pipeline.

## Target
- Android phones (initial testing target: Samsung Galaxy S23+)
- Minecraft Java Edition
- Forge 1.20.1
- Visual/no-code authoring

## Build
Open this repository in Android Studio, allow Gradle sync, then run the `:app` configuration on an Android device or emulator. A successful build still needs to be verified in CI/device testing.

## Planned milestones
1. Android app shell and editor navigation
2. Mod workspace: metadata, items, blocks, tools and recipes
3. Texture/pixel editor
4. Visual procedure graph editor
5. Forge 1.20.1 source/project generation
6. Build, validation and export workflow
