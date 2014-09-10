package test.lifesum.customimagelistadapter;

import java.util.ArrayList;

import test.lifesum.db.MyDatabaseHelper;
import test.lifesum.imagecache.ImageLoader;
import test.lifesum.lifesumalejandrocordon.R;
import test.lifesum.lifesumalejandrocordon.R.drawable;
import test.lifesum.lifesumalejandrocordon.R.id;
import test.lifesum.lifesumalejandrocordon.R.layout;
import test.lifesum.parcelableobjects.ParcelableFood;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.database.DataSetObserver;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.BitmapFactory.Options;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TableLayout.LayoutParams;
import android.widget.TextView;

public class ImageAdapterListView_food_grid extends BaseAdapter {
    private Context mContext;

    private String TAG = getClass().getSimpleName();

    private ArrayList<ParcelableFood> otros;

    private SQLiteDatabase database;

    private Activity actividad;
    private static LayoutInflater inflater=null;
    private Options options;
    
    
    public ImageLoader imageLoader;

    private Dialog mDialog;


    public ImageAdapterListView_food_grid(Context c, Activity a, ArrayList<ParcelableFood> listaotros) {
    	//Log.d(this.getClass().getSimpleName(),"Creador ");
    	mContext = c;
    	
    	options = new Options();
		options.inSampleSize = 6;

        actividad = a;
		
		
		
		otros = listaotros;
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
		return Math.min(32, otros.size());
//        return otros.size();
    }

    public Object getItem(int position) {
    	 return otros.get(position % otros.size());
//        return null;
    }

    public long getItemId(int position) {
//        return 0;
    	return position;
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
        
        LinearLayout info = (LinearLayout) view.findViewById(R.id.TextViewInfo);
        
        
        TextView Fecha = (TextView) view.findViewById(R.id.textViewFecha);


		final RelativeLayout fondo = (RelativeLayout) view.findViewById(R.id.RelativeLayoutPublisher);
		
		
    	if (otros == null) {
			
    		//Pintar lista vacia
		      
    		category.setText("");
//	  		sku.setText("");
//	  		hidden.setText("");
	  		
	  		
	  		//Log.w (this.getClass().getSimpleName()," NULL       --- ");
            
	  		
	        
	        
		} else {
			//Pintar annotations

//			    	posicion = position;
			    	
			        	
			        	if (otros.size() == 0){
			        		      
			        		category.setText(actividad.getResources().getString(R.string.no_elements));
//			        		sku.setText("");
//			        		hidden.setText("");
			        		
			        	} else {

			                
			                //Log.w (this.getClass().getSimpleName()," - getView() - "+position +" ---- " + annotations.get(position).SSID + " ------ " +annotations.get(position).toString());
			                
			                if ( otros.get(position)!=null && (!otros.get(position).toString().equals(""))) {
			                	
			                	
			                	if ((!otros.get(position).getTitle().equals(""))) {
						    		//Log.w(this.getClass().getSimpleName()," SSID = "+annotations.get(position).SSID);
//						    		title.setText(otros.get(position).getTitle());
						    		
						    				title								   .setText(""+otros.get(position).getTitle());
							  				categoryid                             .setText(" categoryid       :  "+otros.get(position).getCategoryid());    
							  		        fiber                                  .setText(" fiber            :  "+otros.get(position).getFiber());    
							  		        headimage                              .setText(" headimage        :  "+otros.get(position).getHeadimage()     );    
							  		        pcsingram                              .setText(" pcsingram        :  "+otros.get(position).getPcsingram()     );    
//							  		        brand                                  .setText(" brand            :  "+otros.get(position).getBrand()     );
							  		        
							  		        brand.setVisibility(View.VISIBLE);
							  		        if (otros.get(position).getBrand().toString().equals("")) {
							  		        	brand.setVisibility(View.GONE);
							  		        }else{
							  		        	brand.setVisibility(View.VISIBLE);
							  		        	brand                                  .setText(" "+otros.get(position).getBrand()     );
							  		        }
							  		        
							  		        
							  		        unsaturatedfat                         .setText(" unsaturatedfat   :  "+otros.get(position).getUnsaturatedfat()     );    
							  		        fat                                    .setText(" fat              :  "+otros.get(position).getFat()     );    
							  		        servingcategory                        .setText(" servingcategory  :  "+otros.get(position).getServingcategory()     );    
							  		        typeofmeasurement                      .setText(" typeofmeasurement:  "+otros.get(position).getTypeofmeasurement()  );    
							  		        protein                                .setText(" protein          :  "+otros.get(position).getProtein()     );    
							  		        defaultserving                         .setText(" defaultserving   :  "+otros.get(position).getDefaultserving()     );    
							  		        mlingram                               .setText(" mlingram         :  "+otros.get(position).getMlingram()     );    
							  		        productid                              .setText(" productid        :  "+otros.get(position).getId()    );    
							  		        saturatedfat                           .setText(" saturatedfat     :  "+otros.get(position).getSaturatedfat()    );    
							  		        category                               .setText(" category         :  "+otros.get(position).getCategory()     ); 
								  		    pcstext                                .setText(" pcstext          :  "+otros.get(position).getPcstext());          
								  	        sodium                                 .setText(" sodium           :  "+otros.get(position).getSodium());               
								  	        carbohydrates                          .setText(" carbohydrates    :  "+otros.get(position).getCarbohydrates()     );      
								  	        showonlysametype                       .setText(" showonlysametype :  "+otros.get(position).getShowonlysametype()     );      
//								  	        calories                               .setText(" calories         :  "+otros.get(position).getCalories()+" kcal"     );
								  	        if (otros.get(position).getPcstext().toString().equals("") ) {
								  	        	calories                               .setText(" "+otros.get(position).getCalories()+" kcal");	
											} else {
												calories                               .setText(" "+otros.get(position).getCalories()+" kcal each "+ otros.get(position).getPcstext() );
											}
								  	        
								  	        serving_version                        .setText(" serving_version  :  "+otros.get(position).getServing_version()     ); 
								  	        sugar                                  .setText(" sugar            :  "+otros.get(position).getSugar()     );            
								  	        measurementid                          .setText(" measurementid    :  "+otros.get(position).getMeasurementid()    );
								  	        cholesterol                            .setText(" cholesterol      :  "+otros.get(position).getCholesterol()  ); 
								  	        gramsperserving                        .setText(" gramsperserving  :  "+otros.get(position).getGramsperserving()    );        
								  	        showmeasurement                        .setText(" showmeasurement  :  "+otros.get(position).getShowmeasurement()     ); 
								  	        potassium                              .setText(" potassium        :  "+otros.get(position).getPotassium()     );       
								  	        verified							   .setText(" verified        :  "+otros.get(position).getVerified()     );
							  	        
							  	        
						    		
//                                    Fecha.setText(otros.get(position).getExpDate());
//                                    codigo.setText(otros.get(position).getPromoCode());

								  	        
								  	info.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View view) {
                                        	
//                                        	Intent intent = new Intent(actividad, FoodListActivity.class);
//                                        	actividad.startActivity(intent);

                                        	
                                        	
                                        	mDialog = new Dialog(actividad,android.R.style.Theme_Translucent_NoTitleBar);
                                    		
                                    		final LayoutInflater inflater = actividad.getLayoutInflater();
//                                    				TextView tv_texto = (TextView) mDialog.findViewById(R.id.tv_texto);
                                    		
                                    		
                                    		View view_dialog = inflater.inflate(R.layout.custom_dialog_food_details, null);
//                                    		TextView tv = (TextView) view_dialog.findViewById(R.id.tv_texto); //id defined in camera.xml
//                                    				tv.setText("");
                                    		
                                    		
                                    		
                                    		
                                    		
                                            TextView categoryid = (TextView) view_dialog.findViewById(R.id.TextViewcategoryid);
                                            TextView fiber = (TextView) view_dialog.findViewById(R.id.TextViewFiber);
                                            TextView headimage = (TextView) view_dialog.findViewById(R.id.TextViewHeadImage);
                                            TextView pcsingram = (TextView) view_dialog.findViewById(R.id.textViewpcsingram);
                                            TextView brand = (TextView) view_dialog.findViewById(R.id.textViewbrand);
                                            TextView unsaturatedfat = (TextView) view_dialog.findViewById(R.id.textViewunsaturatedfat);
                                            TextView fat = (TextView) view_dialog.findViewById(R.id.textViewfat);
                                            TextView servingcategory = (TextView) view_dialog.findViewById(R.id.TextViewservingcategory);
                                            TextView typeofmeasurement = (TextView) view_dialog.findViewById(R.id.TextViewtypeofmeasurement);
                                            TextView protein = (TextView) view_dialog.findViewById(R.id.TextViewprotein);
                                            TextView defaultserving = (TextView) view_dialog.findViewById(R.id.TextViewdefaultserving);
                                            TextView mlingram = (TextView) view_dialog.findViewById(R.id.TextViewmlingram);
                                            TextView productid = (TextView) view_dialog.findViewById(R.id.TextViewproductid);
                                            TextView saturatedfat = (TextView) view_dialog.findViewById(R.id.TextViewsaturatedfat);
                                            TextView category = (TextView) view_dialog.findViewById(R.id.TextViewcategory);
                                            TextView verified = (TextView) view_dialog.findViewById(R.id.TextViewverified);
                                            TextView title = (TextView) view_dialog.findViewById(R.id.TextViewTitle);
                                            
                                            
                                            TextView pcstext = (TextView) view_dialog.findViewById(R.id.TextViewpcstext);
                                            TextView sodium = (TextView) view_dialog.findViewById(R.id.TextViewsodium);
                                            TextView carbohydrates = (TextView) view_dialog.findViewById(R.id.textViewcarbohydrates);
                                            TextView showonlysametype = (TextView) view_dialog.findViewById(R.id.TextViewshowonlysametype);
                                            TextView calories = (TextView) view_dialog.findViewById(R.id.TextViewcalories);
                                            TextView serving_version = (TextView) view_dialog.findViewById(R.id.TextViewserving_version);
                                            TextView sugar = (TextView) view_dialog.findViewById(R.id.TextViewsugar);
                                            TextView measurementid = (TextView) view_dialog.findViewById(R.id.TextViewmeasurementid);
                                            TextView cholesterol = (TextView) view_dialog.findViewById(R.id.TextViewcholesterol);
                                            TextView gramsperserving = (TextView) view_dialog.findViewById(R.id.TextViewgramsperserving);
                                            TextView showmeasurement = (TextView) view_dialog.findViewById(R.id.TextViewshowmeasurement);
                                            TextView potassium = (TextView) view_dialog.findViewById(R.id.TextViewpotassium);
                                            
                                            
                                            
                                            
						    				title								   .setText(""+otros.get(position).getTitle() + " details: ");
							  				categoryid                             .setText(" categoryid       :  "+otros.get(position).getCategoryid());    
							  		        fiber                                  .setText(" fiber            :  "+otros.get(position).getFiber());    
							  		        headimage                              .setText(" headimage        :  "+otros.get(position).getHeadimage()     );    
							  		        pcsingram                              .setText(" pcsingram        :  "+otros.get(position).getPcsingram()     );    
							  		        brand                                  .setText(" brand            :  "+otros.get(position).getBrand()     );    
							  		        unsaturatedfat                         .setText(" unsaturatedfat   :  "+otros.get(position).getUnsaturatedfat()     );    
							  		        fat                                    .setText(" fat              :  "+otros.get(position).getFat()     );    
							  		        servingcategory                        .setText(" servingcategory  :  "+otros.get(position).getServingcategory()     );    
							  		        typeofmeasurement                      .setText(" typeofmeasurement:  "+otros.get(position).getTypeofmeasurement()  );    
							  		        protein                                .setText(" protein          :  "+otros.get(position).getProtein()     );    
							  		        defaultserving                         .setText(" defaultserving   :  "+otros.get(position).getDefaultserving()     );    
							  		        mlingram                               .setText(" mlingram         :  "+otros.get(position).getMlingram()     );    
							  		        productid                              .setText(" productid        :  "+otros.get(position).getId()    );    
							  		        saturatedfat                           .setText(" saturatedfat     :  "+otros.get(position).getSaturatedfat()    );    
							  		        category                               .setText(" category         :  "+otros.get(position).getCategory()     ); 
								  		    pcstext                                .setText(" pcstext          :  "+otros.get(position).getPcstext());          
								  	        sodium                                 .setText(" sodium           :  "+otros.get(position).getSodium());               
								  	        carbohydrates                          .setText(" carbohydrates    :  "+otros.get(position).getCarbohydrates()     );      
								  	        showonlysametype                       .setText(" showonlysametype :  "+otros.get(position).getShowonlysametype()     );      
//								  	        calories                               .setText(" calories         :  "+otros.get(position).getCalories()+" kcal"     );
								  	        if (otros.get(position).getPcstext().toString().equals("") ) {
								  	        	calories                               .setText(" "+otros.get(position).getCalories()+" kcal");	
											} else {
												calories                               .setText(" "+otros.get(position).getCalories()+" kcal each "+ otros.get(position).getPcstext() );
											}
								  	        serving_version                        .setText(" serving_version  :  "+otros.get(position).getServing_version()     ); 
								  	        sugar                                  .setText(" sugar            :  "+otros.get(position).getSugar()     );            
								  	        measurementid                          .setText(" measurementid    :  "+otros.get(position).getMeasurementid()    );
								  	        cholesterol                            .setText(" cholesterol      :  "+otros.get(position).getCholesterol()  ); 
								  	        gramsperserving                        .setText(" gramsperserving  :  "+otros.get(position).getGramsperserving()    );        
								  	        showmeasurement                        .setText(" showmeasurement  :  "+otros.get(position).getShowmeasurement()     ); 
								  	        potassium                              .setText(" potassium        :  "+otros.get(position).getPotassium()     );       
								  	        verified							   .setText(" verified        :  "+otros.get(position).getVerified()     );
                                    		
                                    		
                                    		
//                                    		 spin_provincias = (Spinner) view_dialog.findViewById(R.id.spinnerProvincias);
//                                    		 adapter = new ArrayAdapter<ProvinciaParcelable>(getApplicationContext(), android.R.layout.simple_spinner_item, provincias);
//
//                                    		 
//
//                                    		 
//                                    		 ArrayList<String>  provs =  new ArrayList<String>();
////                                    		 ArrayList<String> provincias_visible = new ArrayList<String>();
//                                    		 for (int i = 0; i < adapter.getCount(); i++) {
//                                    			 provs.add(adapter.getItem(i).getNombre());
//                                    		 }
//                                    		 
//                                    		 ArrayAdapter<String> spinnerArrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, provs);
//
//                                    		 
////                                             adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
////                                             spin_provincias.setAdapter(adapter);
//
//                                    		 spinnerArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//                                             spin_provincias.setAdapter(spinnerArrayAdapter);
//                                             
//                                             
//
//                                             try {
//                                             	SharedPreferences settings = getSharedPreferences(getString(R.string.PREFS_FILE), MODE_PRIVATE);
//                                                 //Lectura
//                                                 settings.getString("seleccion_provincia","");
//                                                 int pos_provincia = settings.getInt("seleccion_posicion_ultima_provincia",-100);
//                                                 
//                                                 if (pos_provincia!=-100) {
//                                                 	spin_provincias.setSelection(pos_provincia, true);
////                                                 	new getTiendasProvincia(spin_provincias.getSelectedItem().toString()).execute();
//                                                 	new getTiendasProvincia(adapter.getItem(spin_provincias.getSelectedItemPosition())).execute();
//                                    				}
//                                    			} catch (Exception e) {
//                                    				// TODO: handle exception
//                                    				
//                                    				  SharedPreferences settings = getSharedPreferences(getString(R.string.PREFS_FILE), MODE_PRIVATE);
//                                    		            //Escritura
//                                    		            SharedPreferences.Editor editor = settings.edit();
//                                    		            editor.putInt("seleccion_posicion_ultima_provincia", 0);
//                                    		            // Commit the edits!
//                                    		            editor.commit();
//                                    		            
//                                    				spin_provincias.setSelection(0, true);
//                                    				
//                                    			}
                                             
                                    		
//                                    		final EditText texto_entrada = (EditText) view_dialog.findViewById(R.id.editText_texto_Entrada); 
                                    		
//                                    		if (type.equals("texto")) {
//                                    		}else if (type.equals("url")) {
//                                    			texto_entrada.setText("http://www.");
//                                    		}
                                    		
                                    		
									  	
								  	        final ImageView save = (ImageView) view_dialog.findViewById(R.id.imageViewSave); //id defined in camera.xml
								  	        save.setOnClickListener(new OnClickListener() {
	                                  			
	                                  			@Override
	                                  			public void onClick(View v) {
	                                  				// TODO Auto-generated method stub
//	                                  				mDialog.cancel();
	                                  				
	                                  				
	                                  				MyDatabaseHelper dbHelper = new MyDatabaseHelper(actividad.getApplicationContext());  
	                                  			    database = dbHelper.getWritableDatabase();  
	                                  				
//	                                  			    dbHelper.onCreate(database);
	                                  			    dbHelper.addFood(otros.get(position));
	                                  			   
	                                  			   
	                                  				if (save.getDrawable().equals(actividad.getResources().getDrawable(R.drawable.ic_star))) {
	                                  					save.setImageDrawable(actividad.getResources().getDrawable(R.drawable.ic_star_trans));
													}else{
														save.setImageDrawable(actividad.getResources().getDrawable(R.drawable.ic_star));
													}
	                                  				
	                                  				
	                                  			}
	                                  		});
                                  		
                                  		
                                    		ImageView close = (ImageView) view_dialog.findViewById(R.id.imageViewClose); //id defined in camera.xml
                                    		close.setOnClickListener(new OnClickListener() {
                                    			
                                    			@Override
                                    			public void onClick(View v) {
                                    				// TODO Auto-generated method stub
                                    				mDialog.cancel();
                                    			}
                                    		});
                                    		
                                    		Button ok = (Button) view_dialog.findViewById(R.id.buttonOk);
                                    		ok.setOnClickListener(new OnClickListener() {
                                    			
                                    			@Override
                                    			public void onClick(View v) {
                                    				// TODO Auto-generated method stub
                                    				
                                    				mDialog.cancel();
                                    			}
                                    		});
                                    		
                                    		
                                    		
                                    		mDialog.addContentView(view_dialog, new  LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));
                                    		mDialog.show();
                                    		
                                        	
                                        }
                                    });
								  	      

								} 
						    	
				                
			                }
			                
			         		
			        	}  						
		}
    	
    	
    	return view;
     
           
    }
    	
    	
    	

    
}

    
      
      
    
    

