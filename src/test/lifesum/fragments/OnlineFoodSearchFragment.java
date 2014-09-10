package test.lifesum.fragments;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import test.lifesum.customimagelistadapter.ImageAdapterListView_food_grid;
import test.lifesum.lifesumalejandrocordon.R;
import test.lifesum.lifesumalejandrocordon.R.id;
import test.lifesum.lifesumalejandrocordon.R.layout;
import test.lifesum.parcelableobjects.ParcelableFood;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.app.Fragment;
import android.content.Context;
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

public class OnlineFoodSearchFragment extends Fragment {

	
	private String TAG = getClass().getSimpleName();
	private GridView grid;
	public static final String HTTPS_GET_API_LIFESUM_V1_SEARCH_QUERY_TYPE_FOOD = "https://api.lifesum.com/v1/search/query?type=food&search=\"";
	private EditText searchText;
	private InputMethodManager imm;
	
	private LinearLayout llsearch,loading;
	
    private int mShortAnimationDuration;
    
    private boolean mContentLoaded;
	
		@Override
	    public View onCreateView(LayoutInflater inflater, ViewGroup container,
	      Bundle savedInstanceState) {
	      // Defines the xml file for the fragment
	      View view = inflater.inflate(R.layout.fragment_online_search_food, container, false);
	      // Setup handles to view objects here
	      // etFoo = (EditText) v.findViewById(R.id.etFoo);
	      
	      
	      loading = (LinearLayout) view.findViewById(R.id.LinearLayoutLoading);
	      
	      
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
					 
					new GetFoodTask(searchText.getText().toString()).execute();
				}
			});
					
					
			llsearch = (LinearLayout) view.findViewById(R.id.LinearLayoutSearch);
//			llsearch.setVisibility(View.VISIBLE);
			
//			grid = (GridView) rootView.findViewById(R.id.gridView);
			grid = (GridView) view.findViewById(R.id.gridView);
			grid.setVisibility(View.GONE);
			
			
			
			
	      return view;
	    }
	 
	 
    public static OnlineFoodSearchFragment newInstance(int position) {
    	OnlineFoodSearchFragment fragment = new OnlineFoodSearchFragment();
        // do some initial setup if needed, for example Listener etc
        return fragment;
    }
    
    
    
    
    
    /**
	 * Represents an asynchronous login/registration task used to authenticate
	 * the user.
	 */
	public class GetFoodTask extends AsyncTask<Void, Void, ArrayList<ParcelableFood>> {
		
		
	     private String queryString;
	        
		private BufferedReader bufferedReader = null;
        private HttpURLConnection con = null;
		private ArrayList<ParcelableFood> productList = null;
    
		
		
		
		
		public GetFoodTask(String QueryString) {
			super();
			
			this.queryString = QueryString;
			
		}

		/* (non-Javadoc)
		 * @see android.os.AsyncTask#onPreExecute()
		 */
		@Override
		protected void onPreExecute() {
			// TODO Auto-generated method stub
			
			loading.setVisibility(View.VISIBLE);
		    
		    
		    
			super.onPreExecute();
		}

		@Override
		protected ArrayList<ParcelableFood> doInBackground(Void... params) {
			// TODO: attempt authentication against a network service.

			//String resultado = "";


            try {

            	
//    		    final String urlString = HTTPS_GET_API_LIFESUM_V1_SEARCH_QUERY_TYPE_FOOD + URLEncoder.encode(queryString) + "\"";
    		    final String urlString = HTTPS_GET_API_LIFESUM_V1_SEARCH_QUERY_TYPE_FOOD + queryString + "\"";


    		    URL url = new URL(urlString);
                con = (HttpURLConnection) url.openConnection();

                // set up url connection to get retrieve information back
                con.setRequestMethod("GET");
                con.setDoInput(true);

                // stuff the authorization request header
                con.setRequestProperty("Authorization",
                        "a794ecd348a3f71894426c65c37fea35da89a295bcbad687ca68a96fbfc7d371");
                con.connect();
                int status = con.getResponseCode();


                switch (status) {
                    case 200:
             
                        // pull the information back from the URL
                        bufferedReader = new BufferedReader(new InputStreamReader(con.getInputStream()));
                        StringBuilder stringBuilder = new StringBuilder();
                        String line;
                        while ((line = bufferedReader.readLine()) != null) {
                            stringBuilder.append(line).append("\n");
                        }


                        // output the information
                        Log.i(TAG,stringBuilder.toString());

                        productList = new ArrayList<ParcelableFood>();
                        JSONObject responseJson = new JSONObject(stringBuilder.toString()).getJSONObject("response");
                        JSONArray productsJson = responseJson.getJSONArray("list");
                        
                        ParcelableFood food = new ParcelableFood();
                        
                        for (int i = 0; i < productsJson.length(); i++) {
                        	
                        	food = new ParcelableFood(productsJson.getJSONObject(i));
                        	
                            productList.add(food);
                            // don't check at every for step, might be a waste of time
//                            if (i % 10 == 0 && isInterrupted()) {
//                                return;
//                            }
                            
                            
                            Log.w( TAG , "-------------------------------------");
                            Log.w( TAG , food.getId());
                            Log.w( TAG , food.getBrand());
                            Log.w( TAG , food.getCalories());
                            Log.w( TAG , food.getTitle());
                            Log.w( TAG , food.getHeadimage());
                            Log.w( TAG , food.getTypeofmeasurement());
                            Log.w( TAG , food.getCategory());
                            
                            
                            
                        }

                        
//                        if (isInterrupted()) {
//                            return;
//                        }

//                        if (handler != null) {
//                            Message message = handler.obtainMessage();
//                            message.what = WHAT_REQUEST_COMPLETED;
//                            message.obj = productList;
//                            handler.sendMessage(message);
//                        }
                        break;
                    case 201:
                }
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (JSONException e) {
                e.printStackTrace();
            } finally {
                if (con != null) {
                    con.disconnect();
                }
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
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
	                  loading.setVisibility(View.GONE);
	                  
	                  
                }else{

                    Toast.makeText(getActivity(), getActivity().getResources().getString(R.string.no_elements), Toast.LENGTH_LONG).show();
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



