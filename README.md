# CruxLib
RPGゲームやその他ゲームを含めた様々な実装の負荷を下げ、共通化させることを目的に制作されました。

## 主な機能
### ゲームサポート
- Item & MetaData
- StatusContainer
### システムサポート
- Registry
- Key

> [!IMPORTANT]
> x.x.xの部分は使用するバージョンに合わせて変更してください
## 使用方法
以下の内容をbuild.gradleに追加してください
> repositories
```
maven {
    url = uri(
        "https://cruxcollective-official.github.io/CruxLib/"
    )
}
```

> dependencies
```
dependencies {
    implementation("org.crux:crux-core:x.x.x")
    implementation("org.crux:crux-annotations:x.x.x")
    kapt("org.crux:crux-processor:x.x.x")
}
```
