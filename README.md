# ShimmerTextView
This is shimmer effect text view for android textview. Reference taken from [Shimmer-Android](https://github.com/RomainPiel/Shimmer-android).
Completely re-written in Kotlin.


## How to use it

*In project level gradle file*
```groovy
allprojects { 
              repositories { 
                            ...
                            maven { 
                                    url 'https://jitpack.io' 
                                  } 
                            }
            }
```

*In Module level gradle file*
```groovy
  dependencies { 
                  implementation 'com.github.sawant-pranit:ShimmerTextView:0.0.1' 
                }
  
```

Add `ShimmerTextView` in your layour:

```xml
<com.pranitsawant.shimmer.library.ShimmerTextView
        android:id="@+id/textView"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Hello World!"
        android:textColor="#444"
        android:textSize="50sp"/>
```

In your activity or fragment:

```kotlin
val shimmer = Shimmer()
shimmer.start(textView)

```
To stop animation:
`shimmer.cancel`
