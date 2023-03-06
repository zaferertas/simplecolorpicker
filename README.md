# Simple Color Picker

[![API](https://img.shields.io/badge/API-19%2B-brightgreen.svg?style=flat)](https://android-arsenal.com/api?level=19)
![Language](https://img.shields.io/badge/language-Kotlin-orange.svg)
[![License](https://img.shields.io/badge/License-Apache%202.0-blue.svg)](https://opensource.org/licenses/Apache-2.0)


A simple color picker library of material colors
<br>

![gif](https://github.com/zaferertas/simplecolorpicker/blob/main/art/screenrecord.gif)

## Gradle

Add below lines to your **root** `build.gradle` file
```groovy
allprojects {
    repositories {
        maven { url 'https://jitpack.io' }
    }
}
```

And add the below dependency to your **module** `build.gradle` file.
```groovy
implementation 'com.github.zaferertas:simplecolorpicker:1.1'
```


## Usage

```kotlin
// Kotlin
SimpleColorPicker.Builder(this)
    .setTitle("Select Color") // Optional
    .setListener(object : ColorPickerListener {
        override fun onColorSelected(color: String) {
            // Use selected color
        }
    })
    .build()
    .show()
 ```

```java
// Java
new SimpleColorPicker.Builder(this)
    .setTitle("Select Color") // Optional
    .setListener(new ColorPickerListener() {
        @Override
        public void onColorSelected(@NonNull String color) {
            // Use selected color
        }
    })
    .build()
    .show();
```

## License

    Copyright 2023, Zafer Ertas

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

         http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
