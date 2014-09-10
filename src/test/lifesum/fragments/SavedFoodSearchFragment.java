package test.lifesum.fragments;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import test.lifesum.customimagelistadapter.ImageAdapterListView_food_grid;
import test.lifesum.db.MyDatabaseHelper;
import test.lifesum.lifesumalejandrocordon.R;
import test.lifesum.lifesumalejandrocordon.R.id;
import test.lifesum.lifesumalejandrocordon.R.layout;
import test.lifesum.parcelableobjects.ParcelableFood;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.app.Fragment;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.Toast;

public class SavedFoodSearchFragment extends Fragment {

	
	private String TAG = getClass().getSimpleName();
	private GridView grid;
	private EditText searchText;
	private InputMethodManager imm;
	
	private LinearLayout llsearch;
	
    private int mShortAnimationDuration;
    
    private boolean mContentLoaded;
	
		@Override
	    public View onCreateView(LayoutInflater inflater, ViewGroup container,
	      Bundle savedInstanceState) {
	      // Defines the xml file for the fragment
	      View view = inflater.inflate(R.layout.fragment_saved_food_search, container, false);
	      // Setup handles to view objects here
	      // etFoo = (EditText) v.findViewById(R.id.etFoo);
	      
	      
	      
	      searchText = (EditText) view.findViewById(R.id.editTextSearch);
			 searchText.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					if (!searchText.getText().toString().equals("")) {
						 mContentLoaded = !mContentLoaded;
			                showContentOrLoadingIndicator(mContentLoaded);
			                searchText.setText("");
					}
				}
			 });
			 
			 
			 imm = (InputMethodManager)getActivity().getSystemService(
			       Context.INPUT_METHOD_SERVICE);

//		        mShortAnimationDuration = getResources().getInteger(android.R.integer.config_shortAnimTime);
		        mShortAnimationDuration = getResources().getInteger(android.R.integer.config_longAnimTime);
		        
		        
			Button go = (Button) view.findViewById(R.id.buttonGo);
			go.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					
					 imm.hideSoftInputFromWindow(searchText.getWindowToken(), 0);
					 
					 
					new SavedGetFoodTask(searchText.getText().toString()).execute();
				}
			});
					
					
			llsearch = (LinearLayout) view.findViewById(R.id.LinearLayoutSearch);
//			llsearch.setVisibility(View.VISIBLE);
			
//			grid = (GridView) rootView.findViewById(R.id.gridView);
			grid = (GridView) view.findViewById(R.id.gridView);
			grid.setVisibility(View.VISIBLE);
			
			
			new SavedGetFoodTask(searchText.getText().toString()).execute();
			
	      return view;
	    }
	 
	 
    public static SavedFoodSearchFragment newInstance(int position) {
    	SavedFoodSearchFragment fragment = new SavedFoodSearchFragment();
        // do some initial setup if needed, for example Listener etc
        return fragment;
    }
    
    
    
    
    
    /**
	 * Represents an asynchronous login/registration task used to authenticate
	 * the user.
	 */
	public class SavedGetFoodTask extends AsyncTask<Void, Void, ArrayList<ParcelableFood>> {
		
		
	     private String queryString;
	        
		private BufferedReader bufferedReader = null;
        private HttpURLConnection con = null;
		private ArrayList<ParcelableFood> productList = null;
    
		
		
		
		
		public SavedGetFoodTask(String QueryString) {
			super();
			
			this.queryString = QueryString;
			
		}

		/* (non-Javadoc)
		 * @see android.os.AsyncTask#onPreExecute()
		 */
		@Override
		protected void onPreExecute() {
			// TODO Auto-generated method stub
			

		    
		    
		    
			super.onPreExecute();
		}

		@Override
		protected ArrayList<ParcelableFood> doInBackground(Void... params) {
			// TODO: attempt authentication against a network service.

			//String resultado = "";


			//	Find in database
			MyDatabaseHelper dbHelper = null;
				try {
					
					dbHelper = new MyDatabaseHelper(getActivity().getApplicationContext());  
				    SQLiteDatabase database = dbHelper.getWritableDatabase();  
				    
				} catch (Exception e) {
					// TODO: handle exception
				}
				
				try {
					productList = dbHelper.getAllFoods();
				} catch (Exception e) {
					// TODO: handle exception
				}
				
            	
			return productList;
            
		}

		@Override
		protected void onPostExecute(final ArrayList<ParcelableFood> food ) {

			if (food!=null) {

                if (food.size()>0){


                    ImageAdapterListView_food_grid adapterscan_grid = new ImageAdapterListView_food_grid(getActivity().getApplicationContext(),getActivity(),food);

//        		    View viewer = mSectionsPagerAdapter.getItem(1).getView();

	        		    grid.setAdapter(adapterscan_grid);
//	        		    adapter.notifyDataSetChanged().

	                  grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
	
	                      @Override
	                      public void onItemClick(AdapterView<?> arg0, View arg1,
	                                              int arg2, long arg3) {
	                          // TODO Auto-generated method stub
	
	
	                      }
	
	                  });
                    
                    
	                  
//	                  grid.setVisibility(View.VISIBLE);
//	                  llsearch.setVisibility(View.GONE);
	                  mContentLoaded = !mContentLoaded;
	                  showContentOrLoadingIndicator(mContentLoaded);
	                  
	                  
	                  
                }else{

                    Toast.makeText(getActivity(), "No hay elementos", Toast.LENGTH_LONG).show();
                    mContentLoaded = !mContentLoaded;
	                showContentOrLoadingIndicator(mContentLoaded);
                }
			}
			
		}
		
		
		
		
		/* (non-Javadoc)
		 * @see android.os.AsyncTask#onCancelled(java.lang.Object)
		 */
		@Override
		protected void onCancelled(ArrayList<ParcelableFood> food) {
			// TODO Auto-generated method stub
			super.onCancelled();
		}

	}
	
    /**
     * Cross-fades between {@link #mContentView} and {@link #mLoadingView}.
     */
    private void showContentOrLoadingIndicator(boolean contentLoaded) {
        // Decide which view to hide and which to show.
        final View showView = contentLoaded ? grid : llsearch;
        final View hideView = contentLoaded ? llsearch : grid;

        // Set the "show" view to 0% opacity but visible, so that it is visible
        // (but fully transparent) during the animation.
        showView.setAlpha(0f);
        showView.setVisibility(View.VISIBLE);

        // Animate the "show" view to 100% opacity, and clear any animation listener set on
        // the view. Remember that listeners are not limited to the specific animation
        // describes in the chained method calls. Listeners are set on the
        // ViewPropertyAnimator object for the view, which persists across several
        // animations.
        showView.animate()
                .alpha(1f)
                .setDuration(mShortAnimationDuration)
                .setListener(null);

        // Animate the "hide" view to 0% opacity. After the animation ends, set its visibility
        // to GONE as an optimization step (it won't participate in layout passes, etc.)
        hideView.animate()
                .alpha(0f)
                .setDuration(mShortAnimationDuration)
                .setListener(new AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationEnd(Animator animation) {
                        hideView.setVisibility(View.GONE);
                    }
                });
    }
    
    
}



