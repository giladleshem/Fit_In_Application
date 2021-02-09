package com.example.fit_in_application.Classes;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class databaseHandler extends SQLiteOpenHelper {
    // All Static variables
    // Database Version
    private static final int DATABASE_VERSION = 1;

    // Database Name
    private static final String DATABASE_NAME = "Foodmanager";

    // Food table name
    private static final String TABLE_FOOD = "Food";
    private static databaseHandler dbhelper;

    // Food Table Columns names
    private static final String KEY_ID= "id";
    private static final String FOOD_CATEGORY = "Food_category";
    private static final String FOOD_ITEM = "Food_item";
    private static final String  PROTEINS = "Proteins";
    private static final String  FAT = "Fats";
    private static final String  CARB = "Carbon";
    private static final String  CALORIES = "Calories";

    public static synchronized databaseHandler getInstance(Context context) {
        // Use the application context, which will ensure that you
        // don't accidentally leak an Activity's context.

        if (dbhelper == null) {
            dbhelper = new databaseHandler(context.getApplicationContext());
        }
        return dbhelper;
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_FOOD_TABLE = "CREATE TABLE " + TABLE_FOOD + " (id INTEGER PRIMARY KEY AUTOINCREMENT,Food_category TEXT,Food_item TEXT,Proteins REAL,Fat REAL,carb REAL,calories REAL)";
        db.execSQL(CREATE_FOOD_TABLE);

        addfood(new food_items_model("Dairy and Egg Products", "Boiled Egg (1 piece)", 5.51f, 4.65f, 0.49f, 68f), db);
        addfood(new food_items_model("Dairy and Egg Products", "Curd (1 mk)", 7.88f, 2.32f, 10.56f, 94f), db);
        addfood(new food_items_model("Dairy and Egg Products", "Egg Cutlets (1 piece)", 4.6f, 8.5f, 11.5f, 140f), db);
        addfood(new food_items_model("Dairy and Egg Products", "Egg and Potato Curry (1 mk)", 7f, 15f, 3f, 200f), db);
        addfood(new food_items_model("Dairy and Egg Products", "Egg Burji (1 mk)", 9f, 12.5f, 7.5f, 195f), db);
        addfood(new food_items_model("Dairy and Egg Products", "Egg Cheese Toast (1 Slice)", 12f, 9f, 9f, 170f), db);
        addfood(new food_items_model("Dairy and Egg Products", "Egg Flip (1 glass)", 9.5f, 8.8f, 17.6f, 189f), db);
        addfood(new food_items_model("Dairy and Egg Products", "Egg Omlette (100 g.)", 11f, 12f, 0.6f, 154f), db);
        addfood(new food_items_model("Dairy and Egg Products", "Egg Omlette Sandwich (1 plate)", 27f, 9.4f, 56.1f, 392.7f), db);
        addfood(new food_items_model("Dairy and Egg Products", "Egg on Potatoes (1 mk)", 7f, 13f, 42f, 320f), db);
        addfood(new food_items_model("Dairy and Egg Products", "Egg on Tomatoes (1 mk)", 21f, 7f, 9f, 320f), db);
        addfood(new food_items_model("Dairy and Egg Products", "Egg Pattice (1 piece)", 4f, 4f, 1f, 60f), db);
        addfood(new food_items_model("Dairy and Egg Products", "Egg Sandwich (1 plate)", 11f, 13f, 18f, 233f), db);
        addfood(new food_items_model("Dairy and Egg Products", "Plain Omlette (1 piece)", 11f, 7f, 0f, 160f), db);
        addfood(new food_items_model("Dairy and Egg Products", "Orange Souffle (1 piece)", 2f, 10f, 3.2f, 110f), db);
        
        addfood(new food_items_model("Baked Products","Baked Potato (1 piece)",2.5f,0.1f,21f,93f),db);
        addfood(new food_items_model("Baked Products","Baked Corn (1 sk)",3.32f,1.28f,25.11f,108f),db);
        addfood(new food_items_model("Baked Products","Baked Stuffed Potato (1 piece)",8f,20f,48f,400f),db);
        addfood(new food_items_model("Baked Products","Big White Bread (1 piece)",2.29f,0.99f,15.18f,80f),db);
        addfood(new food_items_model("Baked Products","Bread Butter (1 slice)",3.66f,3.15f,20.7f,126f),db);
        addfood(new food_items_model("Baked Products","Bread Jam (1 slice)",3.2f,1.47f,22.45f,117f),db);
        addfood(new food_items_model("Baked Products","Brown Bread Butter (1 slice)",1f,2f,7f,115f),db);
        addfood(new food_items_model("Baked Products","Bun Bread (1 slice)",5f,1.5f,26f,130f),db);
        addfood(new food_items_model("Baked Products","Butter Cookies (1 piece)",0.49f,1.94f,5.9f,43f),db);
        addfood(new food_items_model("Baked Products","Butter Toast (1 piece)",4.4f,6.3f,18f,136f),db);
        addfood(new food_items_model("Baked Products","Cream Cracker (1 piece)",0.8f,1.2f,54f,35f),db);
        addfood(new food_items_model("Baked Products","Small White Bread (1 piece)",1.91f,0.82f,12.65f,66f),db);

        addfood(new food_items_model("Baked Products","Cookies, refrigerated dough, peanut butter (100 g.)",8.2f,25f,52f,458f),db);
        addfood(new food_items_model("Baked Products","Pancakes, prepared from recipe, buttermilk (100 g.)",6.8f,9.3f,29f,227f),db);
        addfood(new food_items_model("Baked Products","Pancakes, incomplete, dry mix, whole wheat (100 g.)",11f,1.3f,74f,350f),db);
        addfood(new food_items_model("Baked Products","Bread, toasted, (includes gluten), protein (100 g.)",13f,2.4f,48f,270f),db);
        addfood(new food_items_model("Baked Products","Rolls, reduced-calorie, hamburger or hotdog (100 g.)",8.3f,2f,42f,196f),db);
        addfood(new food_items_model("Baked Products","Cookies, refrigerated dough, chocolate chip (100 g.)",4f,21f,61f,451f),db);
        addfood(new food_items_model("Baked Products","Waffles, ready-to-heat, frozen, gluten-free (100 g.)",2.7f,8.8f,43f,263f),db);
        addfood(new food_items_model("Baked Products","Cookies, baked, refrigerated dough, oatmeal (100 g.)",6f,21f,66f,471f),db);
        addfood(new food_items_model("Baked Products","Pancakes, prepared, complete, dry mix, plain (100 g.)",5.2f,2.5f,37f,194f),db);
        addfood(new food_items_model("Baked Products","Cookies, prepared from recipe, peanut butter (100 g.)",9f,24f,59f,475f),db);
        addfood(new food_items_model("Baked Products","Cookies, vanilla sandwich with creme filling (100 g.)",4.5f,20f,72f,483f),db);
        addfood(new food_items_model("Baked Products","Cake, fat-free, commercially prepared, pound (100 g.)",5.4f,1.2f,61f,283f),db);
        addfood(new food_items_model("Baked Products","Biscuits, baked, frozen, plain or buttermilk (100 g.)",6.2f,11f,54f,338f),db);
        addfood(new food_items_model("Baked Products","Cake, dry mix, enriched, white, pudding-type (100 g.)",3.9f,9.5f,81f,423f),db);
        addfood(new food_items_model("Baked Products","Waffles, ready-to-heat, frozen, chocolate chip (100 g.)",5.8f,10f,46f,297f),db);
        addfood(new food_items_model("Baked Products","Pancakes, prepared, incomplete, dry mix, plain (100 g.)",7.8f,7.7f,29f,218f),db);
        addfood(new food_items_model("Baked Products","Cookies, lowfat, plain or honey, graham crackers (100 g.)",5.7f,5.7f,78f,386f),db);
        addfood(new food_items_model("Baked Products","Biscuits, prepared, dry mix, plain or buttermilk (100 g.)",7.3f,12f,48f,335f),db);
        addfood(new food_items_model("Baked Products","Cookies, enriched, commercially prepared, butter (100 g.)",6.1f,19f,69f,467f),db);
        addfood(new food_items_model("Baked Products","Rolls, wheat/cracked wheat, hamburger or hot dog (100 g.)",12f,3.6f,47f,269f),db);
        addfood(new food_items_model("Baked Products","Cookies, regular, commercially prepared, oatmeal (100 g.)",6.2f,18f,69f,450f),db);
        addfood(new food_items_model("Baked Products","Crackers, sandwich-type with cheese filling, rye (100 g.)",9.2f,22f,61f,481f),db);
        addfood(new food_items_model("Baked Products","Muffin, low-fat, commercially prepared, blueberry (100 g.)",4.2f,4.2f,50f,255f),db);
        addfood(new food_items_model("Baked Products","Cake, prepared from recipe, pineapple upside-down (100 g.)",3.5f,12f,51f,319f),db);
        addfood(new food_items_model("Baked Products","Cookies, regular, sugar wafers with creme filling (100 g.)",3.8f,23f,71f,502f),db);
        addfood(new food_items_model("Baked Products","Waffle, toasted, ready-to-heat, frozen, buttermilk (100 g.)",7.4f,9.5f,48f,309f),db);
        addfood(new food_items_model("Baked Products","Cookies, baked, refrigerated dough, chocolate chip (100 g.)",4.9f,23f,68f,492f),db);
        addfood(new food_items_model("Baked Products","Crackers, multi-seeded and multigrain, gluten-free (100 g.)",11f,16f,66f,453f),db);
        addfood(new food_items_model("Baked Products","Cookies, without lemon juice and rind, ladyfingers (100 g.)",11f,9.1f,60f,363f),db);
        addfood(new food_items_model("Baked Products","Cookies, soft-type, commercially prepared, oatmeal (100 g.)",6.1f,15f,66f,409f),db);
        addfood(new food_items_model("Baked Products","Cake, prepared from recipe without frosting, white (100 g.)",5.4f,12f,57f,357f),db);
        addfood(new food_items_model("Baked Products","Cookies, unenriched, commercially prepared, butter (100 g.)",6.1f,19f,69f,467f),db);
        addfood(new food_items_model("Baked Products","Bread, toasted, commercially prepared, whole-wheat (100 g.)",16f,4.1f,51f,306f),db);
        addfood(new food_items_model("Baked Products","Pie, no-bake type, prepared from mix, coconut cream (100 g.)",2.8f,18f,29f,276f),db);
        addfood(new food_items_model("Baked Products","Cake, prepared from recipe, biscuit-type, shortcake (100 g.)",6.1f,14f,49f,346f),db);
        addfood(new food_items_model("Baked Products","Cake, prepared from recipe without frosting, yellow (100 g.)",5.3f,15f,53f,361f),db);
        addfood(new food_items_model("Baked Products","Cookies, with raisins, prepared from recipe, oatmeal (100 g.)",6.5f,16f,68f,435f),db);
        addfood(new food_items_model("Baked Products","Cookie, chocolate-coated, with peanut butter filling (100 g.)",8.1f,35f,53f,562f),db);
        addfood(new food_items_model("Baked Products","Cookies, sugar free, with creme filling, sugar wafer (100 g.)",3.6f,29f,66f,531f),db);   
        
       
        addfood(new food_items_model("Fast Food","BURGER KING, Egg and Cheese, CROISSAN'WICH with Sausage (100 g.)",12f,22f,16f,308f),db);
        addfood(new food_items_model("Fast Food","Soft, cheese and lettuce, taco with beef (100 g.)",9.3f,9.8f,20f,206f),db);
        addfood(new food_items_model("Fast Food","McDONALD'S, Premium Grilled Chicken Classic Sandwich (100 g.)",14f,4.3f,22f,183f),db);
        addfood(new food_items_model("Fast Food","PIZZA HUT  Super Supreme Pizza, Hand-Tossed Crust (100 g.)",11f,11f,26f,248f),db);
        addfood(new food_items_model("Fast Food","McDONALD'S, McCHICKEN Sandwich (without mayonnaise) (100 g.)",11f,8.5f,31f,240f),db);
        addfood(new food_items_model("Fast Food","DOMINO'S  Cheese Pizza, Ultimate Deep Dish Crust (100 g.)",11f,9.8f,33f,265f),db);
        addfood(new food_items_model("Fast Food","McDONALD'S, Premium Crispy Chicken Classic Sandwich (100 g.)",12f,8.7f,25f,228f),db);
        addfood(new food_items_model("Fast Food","KFC, Skin and Breading, EXTRA CRISPY, Fried Chicken (100 g.)",11f,37f,23f,464f),db);
        addfood(new food_items_model("Fast Food","McDONALD'S, Bacon Ranch Salad with Grilled Chicken (100 g.)",10f,3.1f,3.6f,81f),db);
        addfood(new food_items_model("Fast Food","Pizza, cooked, frozen, thin crust, cheese topping (100 g.)",12f,11f,29f,263f),db);
        addfood(new food_items_model("Fast Food","Fast foods, and beef, cheese, with beans, burrito (100 g.)",7f,6.8f,23f,180f),db);
        addfood(new food_items_model("Fast Food","McDONALD'S, DOUBLE QUARTER POUNDER with Cheese (100 g.)",17f,16f,14f,262f),db);
        addfood(new food_items_model("Fast Food","DOMINO'S Cheese Pizza, Crunchy Thin Crust (100 g.)",12f,15f,28f,298f),db);
        addfood(new food_items_model("Fast Food","PIZZA HUT Cheese Pizza, Hand-Tossed Crust (100 g.)",12f,11f,31f,271f),db);
        addfood(new food_items_model("Fast Food","McDONALD'S, Southern Style Chicken Biscuit (100 g.)",12f,15f,31f,304f),db);
        addfood(new food_items_model("Fast Food","Breaded and fried, onion rings (100 g.)",3.9f,25f,44f,411f),db);
        addfood(new food_items_model("Fast Food","McDONALD'S, QUARTER POUNDER with Cheese (100 g.)",15f,14f,20f,258f),db);
        addfood(new food_items_model("Fast Food","McDONALD'S, NEWMAN'S OWN Cobb Dressing (100 g.)",1.7f,14f,15f,196f),db);
        addfood(new food_items_model("Fast Food","BURGER KING, Original Chicken Sandwich (100 g.)",12f,15f,26f,286f),db);
        addfood(new food_items_model("Fast Food","McDONALD'S, Tangy Honey Mustard Sauce (100 g.)",1.3f,5.8f,29f,167f),db);
        addfood(new food_items_model("Fast Food","McDONALD'S, Crispy, RANCH SNACK WRAP (100 g.)",11f,15f,23f,275f),db);
        addfood(new food_items_model("Fast Food","McDONALD'S, Sausage Biscuit with Egg (100 g.)",11f,22f,19f,311f),db);
        addfood(new food_items_model("Fast Food","BURGER KING, Premium Fish Sandwich (100 g.)",10f,12f,27f,260f),db);
        addfood(new food_items_model("Fast Food","Fast foods, with chicken, quesadilla (100 g.)",15f,15f,24f,294f),db);
        addfood(new food_items_model("Fast Food","BURGER KING, with cheese, WHOPPER (100 g.)",11f,15f,17f,250f),db);
        addfood(new food_items_model("Fast Food","WEND'YS, Crispy Chicken Sandwich (100 g.)",12f,14f,26f,278f),db);

        addfood(new food_items_model("Fast Food","McDONALD'S, McCHICKEN Sandwich (100 g.)",10f,13f,28f,273f),db);
        addfood(new food_items_model("Fast Food","McDONALD'S, Strawberry Sundae (100 g.)",3.2f,4f,28f,158f),db);
        addfood(new food_items_model("Fast Food","McDONALD'S, Chicken McNUGGETS (100 g.)",16f,15f,20f,302f),db);
        addfood(new food_items_model("Fast Food","McDONALD'S, Sausage Burrito (100 g.)",11f,16f,23f,277f),db);
        addfood(new food_items_model("Fast Food","BURGER KING, Chicken Strips (100 g.)",18f,15f,20f,292f),db);
        addfood(new food_items_model("Fast Food","KFC, Crispy Chicken Strips (100 g.)",20f,15f,14f,274f),db);
        addfood(new food_items_model("Fast Food","McDONALD'S, Barbeque Sauce (100 g.)",1.6f,1.2f,37f,165f),db);
        addfood(new food_items_model("Fast Food","WENDY'S, french fries (100 g.)",3.7f,14f,40f,301f),db);
        addfood(new food_items_model("Fast Food","McDONALD'S, Hamburger (100 g.)",13f,10f,30f,264f),db);
        addfood(new food_items_model("Fast Food","McDONALD'S, BIG MAC (100 g.)",12f,15f,20f,257f),db);

    }

    public void addfood(food_items_model food_item) {
        SQLiteDatabase db = this.getWritableDatabase();

        try {
            ContentValues values = new ContentValues();
            values.put(FOOD_CATEGORY, food_item.getfood_category());
            values.put(FOOD_ITEM, food_item.getfood_item());
            values.put(PROTEINS, food_item.getproteins());
            values.put(FAT, food_item.getfat());
            values.put(CARB, food_item.getcarb());
            values.put(CALORIES, food_item.getcalorie());

            db.insertOrThrow(TABLE_FOOD, null, values);
//            db.close(); // Closing database connection
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
    public void addfood(food_items_model food_item, SQLiteDatabase db ) {
//        db=getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(FOOD_CATEGORY, food_item.getfood_category());
        values.put(FOOD_ITEM, food_item.getfood_item());
        values.put(PROTEINS, food_item.getproteins());
        values.put(FAT, food_item.getfat());
        values.put(CARB, food_item.getcarb());
        values.put(CALORIES, food_item.getcalorie());

        db.insert(TABLE_FOOD, null, values);
    }

    public databaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
//        SQLiteDatabase db=this.getWritableDatabase();
    }

    // Getting single food item
    public food_items_model getfood_item(int id) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_FOOD, new String[] { KEY_ID, FOOD_CATEGORY,
                        FOOD_ITEM, PROTEINS, FAT, CARB, CALORIES }, KEY_ID + "=?",
                new String[] { String.valueOf(id) }, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();

        assert cursor != null;
        food_items_model food_item = new food_items_model(Integer.parseInt(cursor.getString(0)),
                cursor.getString(1), cursor.getString(2),Float.parseFloat(cursor.getString(3)),
                Float.parseFloat(cursor.getString(4)),Float.parseFloat(cursor.getString(5)),Float.parseFloat(cursor.getString(6)));
        // return contact
        return food_item;
    }

    public List<String> getfood_category_list() {

        List<String> food_category_list=new ArrayList<>();
        food_category_list.add("Dairy and Egg Products");   //done//
        food_category_list.add("Spices and Herbs");//done//
        food_category_list.add("Fats and Oils");//done//
        food_category_list.add("Soups and Sauces");//done//
        food_category_list.add("Fruits");//done//
        food_category_list.add("Vegetables");//done//
        food_category_list.add("Nut and Seed Products");//done//
        food_category_list.add("Restaurant Foods");
        food_category_list.add("Baby Foods");//done//
        food_category_list.add("Beverages");//done//
        food_category_list.add("Legumes and Legume Products");
        food_category_list.add("Sausages and Luncheon Meats");
        food_category_list.add("Baked Products");
        food_category_list.add("Fast Food");//done//
        food_category_list.add("Poultry Products");
        food_category_list.add("Snacks");
        food_category_list.add("Sweets");//done//
        food_category_list.add("Cereals ,Grains and Pasta");

        return food_category_list;
    }


    public databaseHandler(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public List<food_items_model> getAllfood_items(String food_category) {
        List<food_items_model> food_item_list = new ArrayList<>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_FOOD;

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);


        while(cursor.moveToNext())
        {

            Log.i("Cursor row value",cursor.getPosition()+"");
            if(cursor.getString(cursor.getColumnIndex(FOOD_CATEGORY)).
                    equals(food_category))
            {

                while (cursor.getString(cursor.getColumnIndex(FOOD_CATEGORY)).
                        equals(food_category))
                {
                    food_items_model food_item = new food_items_model();
                    food_item.setfood_category(cursor.getString(cursor.getColumnIndex(FOOD_CATEGORY)));
                    food_item.setfood_item(cursor.getString(cursor.getColumnIndex(FOOD_ITEM)));
                    food_item.setproteins(Float.parseFloat(cursor.getString(cursor.getColumnIndex(PROTEINS))));
                    food_item.setfat(Float.parseFloat(cursor.getString(cursor.getColumnIndex(FAT))));
                    food_item.setcarb(Float.parseFloat(cursor.getString(cursor.getColumnIndex(CARB))));
                    food_item.setcalorie(Float.parseFloat(cursor.getString(cursor.getColumnIndex(CALORIES))));
                    food_item_list.add(food_item);
                    cursor.moveToNext();
                    if(cursor.getPosition()==cursor.getCount()) break;

                }
            }
            if(food_item_list.size()!=0) return food_item_list;
        }

        return food_item_list;
    }


    public List<food_items_model> getAllfooditems() {
        List<food_items_model> food_itemList = new ArrayList<>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_FOOD;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                food_items_model food_item = new food_items_model();
                food_item.setfood_category(cursor.getString(cursor.getColumnIndex(FOOD_CATEGORY)));
                food_item.setfood_item(cursor.getString(cursor.getColumnIndex(FOOD_ITEM)));
                food_item.setproteins(Float.parseFloat(cursor.getString(cursor.getColumnIndex(PROTEINS))));
                food_item.setfat(Float.parseFloat(cursor.getString(cursor.getColumnIndex(FAT))));
                food_item.setcarb(Float.parseFloat(cursor.getString(cursor.getColumnIndex(CARB))));
                food_item.setcalorie(Float.parseFloat(cursor.getString(cursor.getColumnIndex(CALORIES))));
                // Adding contact to list
                food_itemList.add(food_item);
            } while (cursor.moveToNext());
        }

        // return contact list
        return food_itemList;
    }


    public String getFoodCategory(String FoodItem)
    {
        Cursor cursor=null;
        String food_Catg="";
        SQLiteDatabase db = this.getWritableDatabase();
        try {
            cursor = db.rawQuery("SELECT Food_category FROM Food WHERE Food_item=?", new String[] {FoodItem + ""});
            if(cursor.getCount() > 0) {
                cursor.moveToFirst();
                food_Catg = cursor.getString(cursor.getColumnIndex("Food_category"));
            }
            return food_Catg;
        }finally {
            cursor.close();
        }
    }

    public int getFoodItemId(String FoodItem)
    {
        Cursor cursor=null;
        int food_item_id=0;
        SQLiteDatabase db = this.getWritableDatabase();
        try {
            cursor = db.rawQuery("SELECT id FROM Food WHERE Food_item=?", new String[] {FoodItem + ""});
            if(cursor.getCount() > 0) {
                cursor.moveToFirst();
                food_item_id = cursor.getInt(cursor.getColumnIndex("id"));
            }
            return food_item_id;
        }finally {
            cursor.close();
        }
    }



    // Updating single contact
    public int updatefood(food_items_model food_item) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(FOOD_CATEGORY, food_item.getfood_category());
        values.put(FOOD_ITEM, food_item.getfood_item());
        values.put(PROTEINS, food_item.getproteins());
        values.put(FAT, food_item.getfat());
        values.put(CARB, food_item.getcarb());
        values.put(CALORIES, food_item.getcalorie());

        // updating row
        return db.update(TABLE_FOOD, values, FOOD_CATEGORY + " = ?",
                new String[] { food_item.getfood_category() });
    }

    // Deleting single contact
    public void deletefood(food_items_model food_item) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_FOOD, FOOD_CATEGORY + " = ?",
                new String[] { food_item.getfood_category() });
        db.close();
    }


    // Getting contacts Count
    public int getfoodCount() {
        String countQuery = "SELECT  * FROM " + TABLE_FOOD;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        cursor.close();

        // return count
        return cursor.getCount();
    }

}
