# CircularArcProgressView ❤
 The custom circular view to show progress in the form of pie-circle 🟢
 
 [![](https://jitpack.io/v/Vipul12Thawre/CircularArcProgressView.svg)](https://jitpack.io/#Vipul12Thawre/CircularArcProgressView)
 
 # Demo 📱
 ![Demo](https://github.com/Vipul12Thawre/CircularArcProgressView/blob/master/app/showcase/1595765677675.png)



# Gradle setup 🛠️
 - Add below repository in your project level build.gradle
 ```
 maven { url 'https://jitpack.io' }
 ```


- Add below dependency in your app level build.gradle
```
implementation 'com.github.Vipul12Thawre:CircularArcProgressView:<latest-version>'
```



# Usage ⌨️
 - Added below view in your required xml layout
 ```
  <com.vips.circulararcprogressview.CircularArcProgressView
        android:id="@+id/circularArcProgressView"
        android:layout_width="100dp"
        android:layout_height="100dp"
        android:layout_gravity="center"

        app:circleBackgroundColor="#FFFFFF"
        app:circleStrokeWidth="5"
        app:progress="70"
        app:progressColor="#0B783D"
        app:strokeColor="#25cd71" />
        
   ```




# Properties
> _Everything is customizable_ 🥰

**XML**
  - `app:circleBackgroundColor="@color/white" ` : set circle background color
  - `app:circleStrokeWidth="5"` : set circle stroke width
  - `app:progress="70"` : set circle progress
  - `app:progressColor="@color/pinkFaded"` : set progress color
  - `app:strokeColor="@color/darkPink"` : set circle stroke color
  
  
**Kotlin**
- `setCircleBackgroundColor(color:Int)` : set circle background color
- `setCircleStrokeWidth(width:Int)` : set circle stroke width
- `setProgress(progress:Int)` : set circle progress
- `setProgressColor(color: Int)` : set progress color
- `setStrokeColor(color: Int)` : set circle stroke color

# Sample Code
- MainActivity.kt
```
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        
        val circularArcProgressView = findViewById<CircularArcProgressView>(R.id.circularArcProgressView)

        circularArcProgressView.setStrokeColor(ContextCompat.getColor(this, R.color.colorBrown))
        circularArcProgressView.setCircleBackgroundColor(ContextCompat.getColor(this, R.color.colorWhite))
        circularArcProgressView.setProgressColor(ContextCompat.getColor(this, R.color.colorBrownFade))
        circularArcProgressView.setProgress(40)
        circularArcProgressView.setCircleStrokeWidth(7)
    }
    
 }


```

