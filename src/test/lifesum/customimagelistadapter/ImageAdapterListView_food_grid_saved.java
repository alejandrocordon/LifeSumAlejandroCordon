package test.lifesum.customimagelistadapter;

import java.util.ArrayList;

import test.lifesum.imagecache.ImageLoader;
import test.lifesum.lifesumalejandrocordon.R;
import test.lifesum.parcelableobjects.ParcelableFood;
import android.app.Activity;
import android.content.Context;
import android.database.DataSetObserver;
import android.graphics.BitmapFactory.Options;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class ImageAdapterListView_food_grid_saved extends BaseAdapter {

    private String TAG = getClass().getSimpleName();

    private ArrayList<ParcelableFood> foodlist;


    private Activity actividad;
    private static LayoutInflater inflater=null;
    private Options options;
    
    
    public ImageLoader imageLoader;


    public ImageAdapterListView_food_grid_saved(Context c, Activity a, ArrayList<ParcelableFood> listaotros) {
    	//Log.d(this.getClass().getSimpleName(),"Creador ");
    	
    	options = new Options();
		options.inSampleSize = 6;

        actividad = a;
		
		
		
        foodlist = listaotros;
//    	imageLoader=new ImageLoader(c.getApplicationContext());
    	
        inflater = (LayoutInflater)actividad.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        
        
        
        
        //I don't know where to find the web images for the food, but the system support it caching temporal files :)
        imageLoader = new ImageLoader(actividad.getApplicationContext());
        
        
    }



	/* (non-Javadoc)
	 * @see android.widget.BaseAdapter#areAllItemsEnabled()
	 */
	@Override
	public boolean areAllItemsEnabled() {
		// TODO Auto-generated method stub
		return super.areAllItemsEnabled();
	}



	/* (non-Javadoc)
	 * @see android.widget.BaseAdapter#getDropDownView(int, android.view.View, android.view.ViewGroup)
	 */
	@Override
	public View getDropDownView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		return super.getDropDownView(position, convertView, parent);
	}



	/* (non-Javadoc)
	 * @see android.widget.BaseAdapter#getItemViewType(int)
	 */
	@Override
	public int getItemViewType(int position) {
		// TODO Auto-generated method stub
		return super.getItemViewType(position);
	}



	/* (non-Javadoc)
	 * @see android.widget.BaseAdapter#getViewTypeCount()
	 */
	@Override
	public int getViewTypeCount() {
		// TODO Auto-generated method stub
		return super.getViewTypeCount();
	}



	/* (non-Javadoc)
	 * @see android.widget.BaseAdapter#hasStableIds()
	 */
	@Override
	public boolean hasStableIds() {
		// TODO Auto-generated method stub
		return super.hasStableIds();
	}



	/* (non-Javadoc)
	 * @see android.widget.BaseAdapter#isEmpty()
	 */
	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return super.isEmpty();
	}



	/* (non-Javadoc)
	 * @see android.widget.BaseAdapter#notifyDataSetChanged()
	 */
	@Override
	public void notifyDataSetChanged() {
		// TODO Auto-generated method stub
		super.notifyDataSetChanged();
	}



	/* (non-Javadoc)
	 * @see android.widget.BaseAdapter#notifyDataSetInvalidated()
	 */
	@Override
	public void notifyDataSetInvalidated() {
		// TODO Auto-generated method stub
		super.notifyDataSetInvalidated();
	}



	/* (non-Javadoc)
	 * @see android.widget.BaseAdapter#registerDataSetObserver(android.database.DataSetObserver)
	 */
	@Override
	public void registerDataSetObserver(DataSetObserver observer) {
		// TODO Auto-generated method stub
		super.registerDataSetObserver(observer);
	}



	/* (non-Javadoc)
	 * @see android.widget.BaseAdapter#unregisterDataSetObserver(android.database.DataSetObserver)
	 */
	@Override
	public void unregisterDataSetObserver(DataSetObserver observer) {
		// TODO Auto-generated method stub
		super.unregisterDataSetObserver(observer);
	}



	public int getCount() {
		return Math.min(32, foodlist.size());
//        return otros.size();
    }

    public ParcelableFood getItem(int position) {
    	 return foodlist.get(position % foodlist.size());
//        return null;
    }

    public long getItemId(int position) {
//        return 0;
    	return position;
    }
    
    public void removeItem(int position){
    	
    	foodlist.remove(position);
    	notifyDataSetChanged();
    }
    
    
    @Override
	public boolean isEnabled(int position) {
		// TODO Auto-generated method stub
    	
    	
    	 
		return super.isEnabled(position);
		 
	}



	// create a new ImageView for each item referenced by the Adapter
    public View getView(final int position, View convertView, ViewGroup parent) {
    	
    	//Log.d(this.getClass().getSimpleName(),"getView() - "+position +" ---- " + annotations.get(position).SSID + " ------ " +annotations.get(position).toString());
       
    	
   	 View view = convertView;
   	 	if(convertView==null){
   	 		view = inflater.inflate(R.layout.row_layout_otros_grid, null);
        }
        
        
   	 	
   	 	
        TextView categoryid = (TextView) view.findViewById(R.id.TextViewcategoryid);
        TextView fiber = (TextView) view.findViewById(R.id.TextViewFiber);
        TextView headimage = (TextView) view.findViewById(R.id.TextViewHeadImage);
        TextView pcsingram = (TextView) view.findViewById(R.id.textViewpcsingram);
        TextView brand = (TextView) view.findViewById(R.id.textViewbrand);
        TextView unsaturatedfat = (TextView) view.findViewById(R.id.textViewunsaturatedfat);
        TextView fat = (TextView) view.findViewById(R.id.textViewfat);
        TextView servingcategory = (TextView) view.findViewById(R.id.TextViewservingcategory);
        TextView typeofmeasurement = (TextView) view.findViewById(R.id.TextViewtypeofmeasurement);
        TextView protein = (TextView) view.findViewById(R.id.TextViewprotein);
        TextView defaultserving = (TextView) view.findViewById(R.id.TextViewdefaultserving);
        TextView mlingram = (TextView) view.findViewById(R.id.TextViewmlingram);
        TextView productid = (TextView) view.findViewById(R.id.TextViewproductid);
        TextView saturatedfat = (TextView) view.findViewById(R.id.TextViewsaturatedfat);
        TextView category = (TextView) view.findViewById(R.id.TextViewcategory);
        TextView verified = (TextView) view.findViewById(R.id.TextViewverified);
        TextView title = (TextView) view.findViewById(R.id.TextViewTitle);
        
        
        TextView pcstext = (TextView) view.findViewById(R.id.TextViewpcstext);
        TextView sodium = (TextView) view.findViewById(R.id.TextViewsodium);
        TextView carbohydrates = (TextView) view.findViewById(R.id.textViewcarbohydrates);
        TextView showonlysametype = (TextView) view.findViewById(R.id.TextViewshowonlysametype);
        TextView calories = (TextView) view.findViewById(R.id.TextViewcalories);
        TextView serving_version = (TextView) view.findViewById(R.id.TextViewserving_version);
        TextView sugar = (TextView) view.findViewById(R.id.TextViewsugar);
        TextView measurementid = (TextView) view.findViewById(R.id.TextViewmeasurementid);
        TextView cholesterol = (TextView) view.findViewById(R.id.TextViewcholesterol);
        TextView gramsperserving = (TextView) view.findViewById(R.id.TextViewgramsperserving);
        TextView showmeasurement = (TextView) view.findViewById(R.id.TextViewshowmeasurement);
        TextView potassium = (TextView) view.findViewById(R.id.TextViewpotassium);
        
		
    	if (foodlist == null) {
			
    		category.setText("");
	        
		} else {
			        	
			        	if (foodlist.size() == 0){
			        		      
			        		category.setText(actividad.getResources().getString(R.string.no_elements));
			        		
			        	} else {

			                if ( foodlist.get(position)!=null && (!foodlist.get(position).toString().equals(""))) {
			                	
			                	
			                	if ((!foodlist.get(position).getTitle().equals(""))) {
						    		
						    				title								   .setText(""+foodlist.get(position).getTitle());
							  				categoryid                             .setText(" categoryid       :  "+foodlist.get(position).getCategoryid());    
							  		        fiber                                  .setText(" fiber            :  "+foodlist.get(position).getFiber());    
							  		        headimage                              .setText(" headimage        :  "+foodlist.get(position).getHeadimage()     );    
							  		        pcsingram                              .setText(" pcsingram        :  "+foodlist.get(position).getPcsingram()     );    
							  		        
							  		        brand.setVisibility(View.VISIBLE);
							  		        if (foodlist.get(position).getBrand().toString().equals("")) {
							  		        	brand.setVisibility(View.GONE);
							  		        }else{
							  		        	brand.setVisibility(View.VISIBLE);
							  		        	brand                                  .setText(" "+foodlist.get(position).getBrand()     );
							  		        }
							  		        
							  		        unsaturatedfat                         .setText(" unsaturatedfat   :  "+foodlist.get(position).getUnsaturatedfat()     );    
							  		        fat                                    .setText(" fat              :  "+foodlist.get(position).getFat()     );    
							  		        servingcategory                        .setText(" servingcategory  :  "+foodlist.get(position).getServingcategory()     );    
							  		        typeofmeasurement                      .setText(" typeofmeasurement:  "+foodlist.get(position).getTypeofmeasurement()  );    
							  		        protein                                .setText(" protein          :  "+foodlist.get(position).getProtein()     );    
							  		        defaultserving                         .setText(" defaultserving   :  "+foodlist.get(position).getDefaultserving()     );    
							  		        mlingram                               .setText(" mlingram         :  "+foodlist.get(position).getMlingram()     );    
							  		        productid                              .setText(" productid        :  "+foodlist.get(position).getId()    );    
							  		        saturatedfat                           .setText(" saturatedfat     :  "+foodlist.get(position).getSaturatedfat()    );    
							  		        category                               .setText(" category         :  "+foodlist.get(position).getCategory()     ); 
								  		    pcstext                                .setText(" pcstext          :  "+foodlist.get(position).getPcstext());          
								  	        sodium                                 .setText(" sodium           :  "+foodlist.get(position).getSodium());               
								  	        carbohydrates                          .setText(" carbohydrates    :  "+foodlist.get(position).getCarbohydrates()     );      
								  	        showonlysametype                       .setText(" showonlysametype :  "+foodlist.get(position).getShowonlysametype()     );      
//								  	        calories                               .setText(" calories         :  "+foodlist.get(position).getCalories()+" kcal"     );
								  	        if (foodlist.get(position).getPcstext().toString().equals("") ) {
								  	        	calories                               .setText(" "+foodlist.get(position).getCalories()+" kcal");	
											} else {
												calories                               .setText(" "+foodlist.get(position).getCalories()+" kcal each "+ foodlist.get(position).getPcstext() );
											}
								  	        
								  	        serving_version                        .setText(" serving_version  :  "+foodlist.get(position).getServing_version()     ); 
								  	        sugar                                  .setText(" sugar            :  "+foodlist.get(position).getSugar()     );            
								  	        measurementid                          .setText(" measurementid    :  "+foodlist.get(position).getMeasurementid()    );
								  	        cholesterol                            .setText(" cholesterol      :  "+foodlist.get(position).getCholesterol()  ); 
								  	        gramsperserving                        .setText(" gramsperserving  :  "+foodlist.get(position).getGramsperserving()    );        
								  	        showmeasurement                        .setText(" showmeasurement  :  "+foodlist.get(position).getShowmeasurement()     ); 
								  	        potassium                              .setText(" potassium        :  "+foodlist.get(position).getPotassium()     );       
								  	        verified							   .setText(" verified        :  "+foodlist.get(position).getVerified()     );
							  	        
								} 
						    	
			                }
			                
			         		
			        	}  						
		}
    	
    	
    	return view;
     
           
    }
    	
    	
    	

    
}

    
      
      
    
    

