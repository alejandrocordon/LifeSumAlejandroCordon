package test.lifesum.lifesumalejandrocordon;

import java.util.List;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.LinearLayout;

public class IndexFragment extends Fragment {

	
		@Override
	    public View onCreateView(LayoutInflater inflater, ViewGroup container,
	      Bundle savedInstanceState) {
	      // Defines the xml file for the fragment
	      View view = inflater.inflate(R.layout.fragment_lifesum_info, container, false);
	      // Setup handles to view objects here
	      // etFoo = (EditText) v.findViewById(R.id.etFoo);
	      
	      LinearLayout contact = (LinearLayout) view.findViewById(R.id.LinearLayoutLinkedin);
	      contact.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent linkedinIntent;
				try {
					linkedinIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("linkedin://profile/97037876"));
    				final PackageManager packageManager = getActivity().getPackageManager();
    				final List<ResolveInfo> list = packageManager.queryIntentActivities(linkedinIntent, PackageManager.MATCH_DEFAULT_ONLY);
    				if (list.isEmpty()) {
    					linkedinIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.linkedin.com/profile/view?id=97037876"));
    				}
    				startActivity(linkedinIntent);
				} catch (Exception e) {
//    				https://www.linkedin.com/profile/view?id=97037876
    				linkedinIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("linkedin://97037876"));
    				final PackageManager packageManager = getActivity().getPackageManager();
    				final List<ResolveInfo> list = packageManager.queryIntentActivities(linkedinIntent, PackageManager.MATCH_DEFAULT_ONLY);
    				if (list.isEmpty()) {
    					linkedinIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.linkedin.com/profile/view?id=97037876"));
    				}
    				startActivity(linkedinIntent);
				} 
			}
	      });
	      
	      LinearLayout onlinefoodsearch = (LinearLayout) view.findViewById(R.id.LinearLayoutOnlineSearch);
	      onlinefoodsearch.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				FragmentManager fragmentManager = getFragmentManager();
				FragmentTransaction transaction = fragmentManager.beginTransaction();
				
				transaction.replace(R.id.container, OnlineFoodSearchFragment.newInstance(0)); // newInstance() is a static factory method.
				transaction.commit();
			}
		});
	      
	    LinearLayout savedfoodsearch = (LinearLayout) view.findViewById(R.id.LinearLayoutSavedFood);
	    savedfoodsearch.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				FragmentManager fragmentManager = getFragmentManager();
				FragmentTransaction transaction = fragmentManager.beginTransaction();
				
				transaction.replace(R.id.container, SavedFoodSearchFragment.newInstance(0)); // newInstance() is a static factory method.
				transaction.commit();
			}
		});
	      
	      return view;
	    }
	 
	 
    public static IndexFragment newInstance() {
    	IndexFragment fragment = new IndexFragment();
        // do some initial setup if needed, for example Listener etc
        return fragment;
    }
    
    
}



