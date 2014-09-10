package test.lifesum.db;

import java.util.ArrayList;
import java.util.List;

import test.lifesum.parcelableobjects.ParcelableFood;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class MyDatabaseHelper extends SQLiteOpenHelper {

	private static final String DATABASE_NAME = "LifeSumDB";

	private static final int DATABASE_VERSION = 2;

	public MyDatabaseHelper(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}

	// Method is called during creation of the database
	@Override
	public void onCreate(SQLiteDatabase database) {

		String CREATE_CONTACTS_TABLE = "CREATE TABLE " + "Foods" + "(" + "Id"
				+ " INTEGER PRIMARY KEY," + "Title" + " TEXT," + "Categoryid"
				+ " TEXT," + "Fiber" + " TEXT," + "Headimage" + " TEXT,"
				+ "Pcsingram" + " TEXT," + "Brand" + " TEXT,"
				+ "Unsaturatedfat" + " TEXT," + "Fat" + " TEXT,"
				+ "Servingcategory" + " TEXT," + "Typeofmeasurement" + " TEXT,"
				+ "Protein" + " TEXT," + "Defaultserving" + " TEXT,"
				+ "Mlingram" + " TEXT," + "Saturatedfat" + " TEXT,"
				+ "Category" + " TEXT," + "Verified" + " TEXT," 
				+ "Pcstext" + " TEXT," + "Sodium" + " TEXT,"
				+ "Carbohydrates" + " TEXT," + "Showonlysametype" + " TEXT,"
				+ "Calories" + " TEXT," + "Serving_version" + " TEXT,"
				+ "Sugar" + " TEXT," + "Measurementid" + " TEXT,"
				+ "Cholesterol" + " TEXT," + "Gramsperserving" + " TEXT,"
				+ "Showmeasurement" + " TEXT," + "Potassium" + " TEXT" + ") ";

		database.execSQL(CREATE_CONTACTS_TABLE);

	}

	// Method is called during an upgrade of the database,
	@Override
	public void onUpgrade(SQLiteDatabase database, int oldVersion,
			int newVersion) {
		Log.w(MyDatabaseHelper.class.getName(),
				"Upgrading database from version " + oldVersion + " to "
						+ newVersion + ", which will destroy all old data");
		database.execSQL("DROP TABLE IF EXISTS Foods");
		onCreate(database);
	}

		
		
	// Adding new contact
	public void addFood(ParcelableFood food) {

		SQLiteDatabase db = this.getWritableDatabase();

		ContentValues values = new ContentValues();

		values.put("Id", food.getId());
		values.put("Title", food.getTitle());
		values.put("Categoryid", food.getCategoryid());
		values.put("Fiber", food.getFiber());
		values.put("Headimage", food.getHeadimage());
		values.put("Pcsingram", food.getPcsingram());
		values.put("Brand", food.getBrand());
		values.put("Unsaturatedfat", food.getUnsaturatedfat());
		values.put("Fat", food.getFat());
		values.put("Servingcategory", food.getServingcategory());
		values.put("Typeofmeasurement", food.getTypeofmeasurement());
		values.put("Protein", food.getProtein());
		values.put("Defaultserving", food.getDefaultserving());
		values.put("Mlingram", food.getMlingram());
		values.put("Saturatedfat", food.getSaturatedfat());
		values.put("Category", food.getCategory());
		values.put("Verified", food.getVerified());
		values.put("Title", food.getTitle());
		values.put("Pcstext", food.getPcstext());
		values.put("Sodium", food.getSodium());
		values.put("Carbohydrates", food.getCarbohydrates());
		values.put("Showonlysametype", food.getShowonlysametype());
		values.put("Calories", food.getCalories());
		values.put("Serving_version", food.getServing_version());
		values.put("Sugar", food.getSugar());
		values.put("Measurementid", food.getMeasurementid());
		values.put("Cholesterol", food.getCholesterol());
		values.put("Gramsperserving", food.getGramsperserving());
		values.put("Showmeasurement", food.getShowmeasurement());
		values.put("Potassium", food.getPotassium());

		// Inserting Row
		db.insert("Foods", null, values);
		db.close(); // Closing database connection
	}

	// Getting single contact
	public ParcelableFood getFood(String key, String value) {
		SQLiteDatabase db = this.getReadableDatabase();

		Cursor cursor = db.query("Foods", new String[] { "Id", "Title",
				"Categoryid", "Fiber", "Headimage", "Pcsingram", "Brand",
				"Unsaturatedfat", "Fat", "Servingcategory",
				"Typeofmeasurement", "Protein", "Defaultserving", "Mlingram",
				"Saturatedfat", "Category", "Verified", "Title", "Pcstext",
				"Sodium", "Carbohydrates", "Showonlysametype", "Calories",
				"Serving_version", "Sugar", "Measurementid", "Cholesterol",
				"Gramsperserving", "Showmeasurement", "Potassium", }, key
				+ "=?", new String[] { String.valueOf(value) }, null, null,
				null, null);

		if (cursor != null)
			cursor.moveToFirst();

		ParcelableFood food = new ParcelableFood();

		food.setId(cursor.getString(0));
		food.setTitle(cursor.getString(1));
		food.setCategoryid(cursor.getString(2));
		food.setFiber(cursor.getString(3));
		food.setHeadimage(cursor.getString(4));
		food.setPcsingram(cursor.getString(5));
		food.setBrand(cursor.getString(6));
		food.setUnsaturatedfat(cursor.getString(7));
		food.setFat(cursor.getString(8));
		food.setServingcategory(cursor.getString(9));
		food.setTypeofmeasurement(cursor.getString(0));
		food.setProtein(cursor.getString(11));
		food.setDefaultserving(cursor.getString(12));
		food.setMlingram(cursor.getString(13));
		food.setSaturatedfat(cursor.getString(14));
		food.setCategory(cursor.getString(15));
		food.setVerified(cursor.getString(16));
		food.setTitle(cursor.getString(17));
		food.setPcstext(cursor.getString(18));
		food.setSodium(cursor.getString(19));
		food.setCarbohydrates(cursor.getString(20));
		food.setShowonlysametype(cursor.getString(21));
		food.setCalories(cursor.getString(22));
		food.setServing_version(cursor.getString(23));
		food.setSugar(cursor.getString(24));
		food.setMeasurementid(cursor.getString(25));
		food.setCholesterol(cursor.getString(26));
		food.setGramsperserving(cursor.getString(27));
		food.setShowmeasurement(cursor.getString(28));
		food.setPotassium(cursor.getString(29));

		// Integer.parseInt(cursor.getString(0)),
		// cursor.getString(1), cursor.getString(2));
		// return contact
		return food;
	}

	// Getting All Contacts
	public ArrayList<ParcelableFood> getAllFoods() {
		
		ArrayList<ParcelableFood> foodList = new ArrayList<ParcelableFood>();
	    // Select All Query
	    String selectQuery = "SELECT  * FROM " + "Foods";
	 
	    SQLiteDatabase db = this.getWritableDatabase();
	    Cursor cursor = db.rawQuery(selectQuery, null);
	 
	    // looping through all rows and adding to list
	    if (cursor.moveToFirst()) {
	        do {
	        	ParcelableFood food = new ParcelableFood();
	        	food.setId(cursor.getString(0));
	    		food.setTitle(cursor.getString(1));
	    		food.setCategoryid(cursor.getString(2));
	    		food.setFiber(cursor.getString(3));
	    		food.setHeadimage(cursor.getString(4));
	    		food.setPcsingram(cursor.getString(5));
	    		food.setBrand(cursor.getString(6));
	    		food.setUnsaturatedfat(cursor.getString(7));
	    		food.setFat(cursor.getString(8));
	    		food.setServingcategory(cursor.getString(9));
	    		food.setTypeofmeasurement(cursor.getString(0));
	    		food.setProtein(cursor.getString(11));
	    		food.setDefaultserving(cursor.getString(12));
	    		food.setMlingram(cursor.getString(13));
	    		food.setSaturatedfat(cursor.getString(14));
	    		food.setCategory(cursor.getString(15));
	    		food.setVerified(cursor.getString(16));
	    		food.setPcstext(cursor.getString(17));
	    		food.setSodium(cursor.getString(18));
	    		food.setCarbohydrates(cursor.getString(19));
	    		food.setShowonlysametype(cursor.getString(20));
	    		food.setCalories(cursor.getString(21));
	    		food.setServing_version(cursor.getString(22));
	    		food.setSugar(cursor.getString(23));
	    		food.setMeasurementid(cursor.getString(24));
	    		food.setCholesterol(cursor.getString(25));
	    		food.setGramsperserving(cursor.getString(26));
	    		food.setShowmeasurement(cursor.getString(27));
	    		food.setPotassium(cursor.getString(28));	            // Adding contact to list
	    		foodList.add(food);
	        } while (cursor.moveToNext());
	    }
	 
	    // return contact list
	    return foodList;
	    
	    
	    
	}

	// Getting contacts Count
	public int getFoodCount() {
		String countQuery = "SELECT  * FROM " + "Foods";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        cursor.close();
 
        // return count
        return cursor.getCount();

        
	}

	// Updating single contact
	public int updateFood(ParcelableFood food) {
		SQLiteDatabase db = this.getWritableDatabase();
		 
	    ContentValues values = new ContentValues();
	    values.put("Id", food.getId());
		values.put("Title", food.getTitle());
		values.put("Categoryid", food.getCategoryid());
		values.put("Fiber", food.getFiber());
		values.put("Headimage", food.getHeadimage());
		values.put("Pcsingram", food.getPcsingram());
		values.put("Brand", food.getBrand());
		values.put("Unsaturatedfat", food.getUnsaturatedfat());
		values.put("Fat", food.getFat());
		values.put("Servingcategory", food.getServingcategory());
		values.put("Typeofmeasurement", food.getTypeofmeasurement());
		values.put("Protein", food.getProtein());
		values.put("Defaultserving", food.getDefaultserving());
		values.put("Mlingram", food.getMlingram());
		values.put("Saturatedfat", food.getSaturatedfat());
		values.put("Category", food.getCategory());
		values.put("Verified", food.getVerified());
		values.put("Title", food.getTitle());
		values.put("Pcstext", food.getPcstext());
		values.put("Sodium", food.getSodium());
		values.put("Carbohydrates", food.getCarbohydrates());
		values.put("Showonlysametype", food.getShowonlysametype());
		values.put("Calories", food.getCalories());
		values.put("Serving_version", food.getServing_version());
		values.put("Sugar", food.getSugar());
		values.put("Measurementid", food.getMeasurementid());
		values.put("Cholesterol", food.getCholesterol());
		values.put("Gramsperserving", food.getGramsperserving());
		values.put("Showmeasurement", food.getShowmeasurement());
		values.put("Potassium", food.getPotassium());
	    // updating row
	    return db.update("Foods", values, "Id" + " = ?",
	            new String[] { String.valueOf(food.getId()) });
	}

	// Deleting single contact
	public void deleteFood(ParcelableFood food) {
		
		SQLiteDatabase db = this.getWritableDatabase();
	    db.delete("Foods", "Id" + " = ?",
	            new String[] { food.getId() });
	    db.close();
	    
	    
	}
}
