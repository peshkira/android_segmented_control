SEGMENTED CONTROL
=================
A little widget to create an iOS-like Segmented Control for android.
The segmented control widget in iOS is sometimes great and isn't very different then a beautiful styled radio button.
I created a little widget, that imitates that behavior. It creates buttons and styles their edges accordingly.

[![](http://petarpetrov.org/android/sc_demo.png)]

USAGE
-----------
Checkout this project and add it as an android library to your project. Unfortunately, due to Android limitations I cannot make a jar library out of this,
as it needs references to the R file and the resources.

You can create as many buttons as you like, but I recommend to keep them under 5. By default the first (left most) button is selected and the 
labels of the buttons are trimmed if their length is longer than 10 characters. You can overwrite this behavior (see the examples).

** Basic Usage **

``` xml
<com.petpet.sc.widget.SegmentedControl
            android:id="@+id/segmented_control"
            style="@style/SegmentedControl">

            <Button
                android:id="@+id/filter1"
                android:text="Filter 1" 
                style="@style/SmallSegmentedFilter" />

            <View style="@style/VerticalLine" /> <!-- not necessary, but looks better if you have more than two buttons--> 

            <Button
                android:id="@+id/filter2"
                android:text="Filter 2"
                style="@style/SmallSegmentedFilter" />
                
        </com.petpet.sc.widget.SegmentedControl>
```

** Overwrite Default Behaviour **

include this into your layout namespaces:

``` xml
xmlns:sc="http://schemas.android.com/apk/res/com.petpet.sc"
```

``` xml
<com.petpet.sc.widget.SegmentedControl
            android:id="@+id/segmented_control"
            style="@style/SegmentedControl">

    <!-- first button not selected -->
    <!-- max text length before trim = 15 characters -->
            <Button
                android:id="@+id/filter1"
                android:text="Filter 1" 
                style="@style/SmallSegmentedFilter" 
                sc:first_selected="false"
                sc:label_maxlength="15"/>
                
        </com.petpet.sc.widget.SegmentedControl>
```

LIMITATIONS
--------------
Unfortunately, android poses some limitations and that is why I was forced to do some things that I don't like. If you have
other ideas, feel free to comment or contribute.

 - no jar library can be created, as I use some resources and need the reference to the generated R file in order to read the properties. Only an android library project allows the usage of own R class as it includes it automatically during build.
 - Due to an android bug a little hack is used in order to make only some of the corners rounded. Thanks to this SO Thread: http://stackoverflow.com/questions/6003382/how-can-i-work-around-android-issue-9161-where-bottomrightradius-and-bottomleft
