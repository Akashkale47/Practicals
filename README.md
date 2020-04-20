# Practicals

# ALL THREE PRATICALS ARE THERE 
1. SMSMANAGER 
2. ANDROIDSQLITE
3. SAVETODATAMANAGER


STEP:1 - for changing praticals (because all pratical are done on one project so checkout carefuly before proceed)

public void next(View view) 
        Intent intent = new Intent(MainActivity.this, YOUR_CLASS_NAME (i.e AndroidSqlite/SaveTodata).class);
        startActivity(intent);
    
    
e.g:-

public void next(View view) 
        Intent intent = new Intent(MainActivity.this, SaveDataToMemoryActivity.class);
        startActivity(intent);
    
    
STEP:-2 CHANGE NAME AND ROLL NAME, Checkout in Layout folder-> and Search TextView name (Perform By :-)

TextView
        <br>android:id="@+id/tv_subtitle"</br>
        <br>android:layout_width="match_parent"</br>
        <br>android:layout_height="wrap_content"</br>
        <br>android:gravity="center_horizontal"</br>
        <br>android:text="Perform By :- Your_Name (Your_Roll_Number) "</br>
        <br>android:textColor="@android:color/black"</br>
        <br>android:textSize="14sp"</br>
