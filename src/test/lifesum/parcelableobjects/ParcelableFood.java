package test.lifesum.lifesumalejandrocordon;


import org.json.JSONException;
import org.json.JSONObject;

import android.os.Parcel;
import android.os.Parcelable;


public class ParcelableFood implements Parcelable {

	private String categoryid="";
    private String fiber="";
    private String headimage="";
    private String pcsingram="";
	private String brand="";
    private String unsaturatedfat="";
    private String fat="";
    private String servingcategory="";
	private String typeofmeasurement="";
    private String protein="";
    private String defaultserving="";
    private String mlingram="";
	private String id="";
    private String saturatedfat="";
    private String category="";
	private String verified="";
    private String title="";
    private String pcstext="";
    private String sodium="";
	private String carbohydrates="";
    private String showonlysametype="";
    private String calories="";
    private String serving_version="";
	private String sugar="";
    private String measurementid="";
    private String cholesterol="";
    private String gramsperserving="";
    private String showmeasurement="";
    private String potassium="";
    
    
	/**
	 * Standard basic constructor for non-parcel
	 * object creation
	 */
	public ParcelableFood() { ; };

	/**
	 *
	 * Constructor to use when re-constructing object
	 * from a parcel
	 *
	 * @param in a parcel from which to read this object
	 */
	public ParcelableFood(Parcel in) {
		readFromParcel(in);
	}

	
    public ParcelableFood(JSONObject jsonObject) throws JSONException {
        this(jsonObject.getString("serving_version"), jsonObject.getString("categoryid"), jsonObject.getString("fiber"), jsonObject.getString("headimage"), jsonObject.getString("pcsingram"),
                jsonObject.getString("brand"), jsonObject.getString("unsaturatedfat"), jsonObject.getString("fat"), jsonObject.getString("servingcategory"), jsonObject.getString("typeofmeasurement"),
                jsonObject.getString("protein"), jsonObject.getString("defaultserving"), jsonObject.getString("mlingram"), jsonObject.getString("id"), jsonObject.getString("saturatedfat"),
                jsonObject.getString("category"), jsonObject.getString("verified"), jsonObject.getString("title"), jsonObject.getString("pcstext"), jsonObject.getString("sodium"),
                jsonObject.getString("carbohydrates"), jsonObject.getString("showonlysametype"), jsonObject.getString("calories"), jsonObject.getString("sugar"), jsonObject.getString("measurementid"),
                jsonObject.getString("cholesterol"), jsonObject.getString("gramsperserving"), jsonObject.getString("showmeasurement"), jsonObject.getString("potassium"));
    }
 

    public ParcelableFood(String serving_version, String categoryid, String fiber, String headimage, String pcsingram,
            String brand, String unsaturatedfat, String fat, String servingcategory, String typeofmeasurement,
            String protein, String defaultserving, String mlingram, String id, String saturatedfat,
            String category, String verified, String title, String pcstext, String sodium,
            String carbohydrates, String showonlysametype, String calories, String sugar, String measurementid,
            String cholesterol, String gramsperserving, String showmeasurement, String potassium) {

    		 this.serving_version = serving_version;
			 this.categoryid = categoryid;
			 this.fiber = fiber;
			 this.headimage = headimage;
			 this.pcsingram = pcsingram;
			 this.brand = brand;
			 this.unsaturatedfat = unsaturatedfat;
			 this.fat = fat;
			 this.servingcategory = servingcategory;
			 this.typeofmeasurement = typeofmeasurement;
			 this.protein = protein;
			 this.defaultserving = defaultserving;
			 this.mlingram = mlingram;
			 this.id = id;
			 this.saturatedfat = saturatedfat;
			 this.category = category;
			 this.verified = verified;
			 this.title = title;
			 this.pcstext = pcstext;
			 this.sodium = sodium;
			 this.carbohydrates = carbohydrates;
			 this.showonlysametype = showonlysametype;
			 this.calories = calories;
			 this.sugar = sugar;
			 this.measurementid = measurementid;
			 this.cholesterol = cholesterol;
			 this.gramsperserving = gramsperserving;
			 this.showmeasurement = showmeasurement;
			 this.potassium = potassium;
			 
}
    
    
    
	/**
	 * @return the categoryid
	 */
	public String getCategoryid() {
		return categoryid;
	}

	/**
	 * @param categoryid the categoryid to set
	 */
	public void setCategoryid(String categoryid) {
		this.categoryid = categoryid;
	}

	/**
	 * @return the fiber
	 */
	public String getFiber() {
		return fiber;
	}

	/**
	 * @param fiber the fiber to set
	 */
	public void setFiber(String fiber) {
		this.fiber = fiber;
	}

	/**
	 * @return the headimage
	 */
	public String getHeadimage() {
		return headimage;
	}

	/**
	 * @param headimage the headimage to set
	 */
	public void setHeadimage(String headimage) {
		this.headimage = headimage;
	}

	/**
	 * @return the pcsingram
	 */
	public String getPcsingram() {
		return pcsingram;
	}

	/**
	 * @param pcsingram the pcsingram to set
	 */
	public void setPcsingram(String pcsingram) {
		this.pcsingram = pcsingram;
	}

	/**
	 * @return the brand
	 */
	public String getBrand() {
		return brand;
	}

	/**
	 * @param brand the brand to set
	 */
	public void setBrand(String brand) {
		this.brand = brand;
	}

	/**
	 * @return the unsaturatedfat
	 */
	public String getUnsaturatedfat() {
		return unsaturatedfat;
	}

	/**
	 * @param unsaturatedfat the unsaturatedfat to set
	 */
	public void setUnsaturatedfat(String unsaturatedfat) {
		this.unsaturatedfat = unsaturatedfat;
	}

	/**
	 * @return the fat
	 */
	public String getFat() {
		return fat;
	}

	/**
	 * @param fat the fat to set
	 */
	public void setFat(String fat) {
		this.fat = fat;
	}

	/**
	 * @return the servingcategory
	 */
	public String getServingcategory() {
		return servingcategory;
	}

	/**
	 * @param servingcategory the servingcategory to set
	 */
	public void setServingcategory(String servingcategory) {
		this.servingcategory = servingcategory;
	}

	/**
	 * @return the typeofmeasurement
	 */
	public String getTypeofmeasurement() {
		return typeofmeasurement;
	}

	/**
	 * @param typeofmeasurement the typeofmeasurement to set
	 */
	public void setTypeofmeasurement(String typeofmeasurement) {
		this.typeofmeasurement = typeofmeasurement;
	}

	/**
	 * @return the protein
	 */
	public String getProtein() {
		return protein;
	}

	/**
	 * @param protein the protein to set
	 */
	public void setProtein(String protein) {
		this.protein = protein;
	}

	/**
	 * @return the defaultserving
	 */
	public String getDefaultserving() {
		return defaultserving;
	}

	/**
	 * @param defaultserving the defaultserving to set
	 */
	public void setDefaultserving(String defaultserving) {
		this.defaultserving = defaultserving;
	}

	/**
	 * @return the mlingram
	 */
	public String getMlingram() {
		return mlingram;
	}

	/**
	 * @param mlingram the mlingram to set
	 */
	public void setMlingram(String mlingram) {
		this.mlingram = mlingram;
	}

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the saturatedfat
	 */
	public String getSaturatedfat() {
		return saturatedfat;
	}

	/**
	 * @param saturatedfat the saturatedfat to set
	 */
	public void setSaturatedfat(String saturatedfat) {
		this.saturatedfat = saturatedfat;
	}

	/**
	 * @return the category
	 */
	public String getCategory() {
		return category;
	}

	/**
	 * @param category the category to set
	 */
	public void setCategory(String category) {
		this.category = category;
	}

	/**
	 * @return the verified
	 */
	public String getVerified() {
		return verified;
	}

	/**
	 * @param verified the verified to set
	 */
	public void setVerified(String verified) {
		this.verified = verified;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the pcstext
	 */
	public String getPcstext() {
		return pcstext;
	}

	/**
	 * @param pcstext the pcstext to set
	 */
	public void setPcstext(String pcstext) {
		this.pcstext = pcstext;
	}

	/**
	 * @return the sodium
	 */
	public String getSodium() {
		return sodium;
	}

	/**
	 * @param sodium the sodium to set
	 */
	public void setSodium(String sodium) {
		this.sodium = sodium;
	}

	/**
	 * @return the carbohydrates
	 */
	public String getCarbohydrates() {
		return carbohydrates;
	}

	/**
	 * @param carbohydrates the carbohydrates to set
	 */
	public void setCarbohydrates(String carbohydrates) {
		this.carbohydrates = carbohydrates;
	}

	/**
	 * @return the showonlysametype
	 */
	public String getShowonlysametype() {
		return showonlysametype;
	}

	/**
	 * @param showonlysametype the showonlysametype to set
	 */
	public void setShowonlysametype(String showonlysametype) {
		this.showonlysametype = showonlysametype;
	}

	/**
	 * @return the calories
	 */
	public String getCalories() {
		return calories;
	}

	/**
	 * @param calories the calories to set
	 */
	public void setCalories(String calories) {
		this.calories = calories;
	}

	/**
	 * @return the serving_version
	 */
	public String getServing_version() {
		return serving_version;
	}

	/**
	 * @param serving_version the serving_version to set
	 */
	public void setServing_version(String serving_version) {
		this.serving_version = serving_version;
	}

	/**
	 * @return the sugar
	 */
	public String getSugar() {
		return sugar;
	}

	/**
	 * @param sugar the sugar to set
	 */
	public void setSugar(String sugar) {
		this.sugar = sugar;
	}

	/**
	 * @return the measurementid
	 */
	public String getMeasurementid() {
		return measurementid;
	}

	/**
	 * @param measurementid the measurementid to set
	 */
	public void setMeasurementid(String measurementid) {
		this.measurementid = measurementid;
	}

	/**
	 * @return the cholesterol
	 */
	public String getCholesterol() {
		return cholesterol;
	}

	/**
	 * @param cholesterol the cholesterol to set
	 */
	public void setCholesterol(String cholesterol) {
		this.cholesterol = cholesterol;
	}

	/**
	 * @return the gramsperserving
	 */
	public String getGramsperserving() {
		return gramsperserving;
	}

	/**
	 * @param gramsperserving the gramsperserving to set
	 */
	public void setGramsperserving(String gramsperserving) {
		this.gramsperserving = gramsperserving;
	}

	/**
	 * @return the showmeasurement
	 */
	public String getShowmeasurement() {
		return showmeasurement;
	}

	/**
	 * @param showmeasurement the showmeasurement to set
	 */
	public void setShowmeasurement(String showmeasurement) {
		this.showmeasurement = showmeasurement;
	}

	/**
	 * @return the potassium
	 */
	public String getPotassium() {
		return potassium;
	}

	/**
	 * @param potassium the potassium to set
	 */
	public void setPotassium(String potassium) {
		this.potassium = potassium;
	}

	public static Creator getCreator() {
		return CREATOR;
	}

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {

		// We just need to write each field into the
		// parcel. When we read from parcel, they
		// will come back in the same order
        
        dest.writeString(categoryid);
        dest.writeString(fiber);     
        dest.writeString(headimage); 
        dest.writeString(pcsingram); 
        dest.writeString(brand);     
        dest.writeString(unsaturatedfat);          
        dest.writeString(fat);       
        dest.writeString(servingcategory);         
        dest.writeString(typeofmeasurement);       
        dest.writeString(protein);   
        dest.writeString(defaultserving);          
        dest.writeString(mlingram);  
        dest.writeString(id);        
        dest.writeString(saturatedfat);            
        dest.writeString(category);  
        dest.writeString(verified);  
        dest.writeString(title);     
        dest.writeString(pcstext);   
        dest.writeString(sodium);    
        dest.writeString(carbohydrates);           
        dest.writeString(showonlysametype);        
        dest.writeString(calories);  
        dest.writeString(serving_version);         
        dest.writeString(sugar);     
        dest.writeString(measurementid);           
        dest.writeString(cholesterol);             
        dest.writeString(gramsperserving);         
        dest.writeString(showmeasurement);         
        dest.writeString(potassium); 
        
	}

	/**
	 *
	 * Called from the constructor to create this
	 * object from a parcel.
	 *
	 * @param in parcel from which to re-create object
	 */
	private void readFromParcel(Parcel in) {

		// We just need to read back each
		// field in the order that it was
		// written to the parcel
        
        categoryid= in.readString();
        fiber= in.readString();     
        headimage= in.readString(); 
        pcsingram= in.readString(); 
        brand= in.readString();     
        unsaturatedfat="";    
        fat= in.readString();       
        servingcategory="";   
        typeofmeasurement=""; 
        protein= in.readString();   
        defaultserving="";    
        mlingram= in.readString();  
        id= in.readString();        
        saturatedfat="";      
        category= in.readString();  
        verified= in.readString();  
        title= in.readString();     
        pcstext= in.readString();   
        sodium= in.readString();    
        carbohydrates="";     
        showonlysametype="";  
        calories= in.readString();  
        serving_version="";   
        sugar= in.readString();     
        measurementid="";     
        cholesterol="";       
        gramsperserving="";   
        showmeasurement="";   
        potassium= in.readString(); 

	}



	/**
     *
     * This field is needed for Android to be able to
     * create new objects, individually or as arrays.
     *
     * This also means that you can use use the default
     * constructor to create the object and use another
     * method to hyrdate it as necessary.
     *
     * I just find it easier to use the constructor.
     * It makes sense for the way my brain thinks ;-)
     *
     */
    public static final Creator CREATOR =
    	new Creator() {
            public ParcelableFood createFromParcel(Parcel in) {
                return new ParcelableFood(in);
            }
 
            public ParcelableFood[] newArray(int size) {
                return new ParcelableFood[size];
            }
        };
 
}