package test.lifesum.lifesumalejandrocordon;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class IndexFragment extends Fragment {

	
		@Override
	    public View onCreateView(LayoutInflater inflater, ViewGroup container,
	      Bundle savedInstanceState) {
	      // Defines the xml file for the fragment
	      View view = inflater.inflate(R.layout.fragment_lifesum_info, container, false);
	      // Setup handles to view objects here
	      // etFoo = (EditText) v.findViewById(R.id.etFoo);
	      return view;
	    }
	 
	 
    public static IndexFragment newInstance() {
    	IndexFragment fragment = new IndexFragment();
        // do some initial setup if needed, for example Listener etc
        return fragment;
    }
    
    
}



