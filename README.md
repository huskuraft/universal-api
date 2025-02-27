# Universal API

[Universal API]() is a library for building multiplatform minecraft mods.

## Targets

```groovy
dependencies {
    // api = "fabric-api" | "quilt-api" | "forge-api" | "neoforge-api" | ...
    // minecraft = "1.17.1" | "1.18.1" | "1.19.2" | "1.19.3" | ...
    universalTarget "dev.huskuraft.universal:${api}:${minecraft}"
}
```

| Minecraft <br/>`version` | Minecraft Compatibility  | Fabric <br/> `fabric-api` | Quilt <br/> `quilt-api` | Forge <br/> `forge-api` | NeoForge <br/> `neoforge-api` |
|--------------------------|--------------------------|:-------------------------:|:-----------------------:|:-----------------------:|:-----------------------------:|
| `1.21.3`                 | `1.21.3` `1.21.2`        |          &check;          |         &check;         |         &check;         |            &check;            |
| `1.21.1`                 | `1.21.1` `1.21`          |          &check;          |         &check;         |         &check;         |            &check;            |
| `1.20.6`                 | `1.20.6` `1.20.5`        |          &check;          |         &check;         |         &check;         |            &check;            |
| `1.20.4`                 | `1.20.4` `1.20.3`        |          &check;          |         &check;         |         &check;         |                               |
| `1.20.2`                 | `1.20.2`                 |          &check;          |         &check;         |         &check;         |                               |
| `1.20.1`                 | `1.20.1` `1.20`          |          &check;          |         &check;         |         &check;         |                               |
| `1.19.4`                 | `1.19.4`                 |          &check;          |         &check;         |         &check;         |                               |
| `1.19.3`                 | `1.19.3`                 |          &check;          |         &check;         |         &check;         |                               |
| `1.19.2`                 | `1.19.2` `1.19.1` `1.19` |          &check;          |         &check;         |         &check;         |                               |
| `1.18.2`                 | `1.18.2`                 |          &check;          |         &check;         |         &check;         |                               |
| `1.18.1`                 | `1.18.1` `1.18`          |          &check;          |         &check;         |         &check;         |                               |
| `1.17.1`                 | `1.17.1`                 |          &check;          |         &check;         |         &check;         |                               |

### Plugins

| Name                                                                                                                                                                    | Supported | Note                                                   |
|-------------------------------------------------------------------------------------------------------------------------------------------------------------------------|:---------:|--------------------------------------------------------|
| [Open Parties and Claims](https://modrinth.com/mod/open-parties-and-claims)                                                                                             |  &check;  | Allows you to claim chunks and add build permissions.  |
| [FTB Chunks Fabric](https://www.curseforge.com/minecraft/mc-mods/ftb-chunks-fabric) / [FTB Chunks Forge](https://www.curseforge.com/minecraft/mc-mods/ftb-chunks-forge) |  &check;  | Allows you to claim chunks and add build permissions.  |
| [ViaFabric](https://github.com/ViaVersion/ViaFabric) / [ViaForge](https://github.com/ViaVersion/ViaForge)                                                               |  &check;  | Allows you to connect to a different Minecraft version |

## License

Universal API is licensed under LGPLv3.
