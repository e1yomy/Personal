package elyo.my.shuffle;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link Controles.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link Controles#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Controles extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    Context c;
    SeekBar seek;
    ImageButton anterior, retroceder, stop, play, avanzar, siguiente;
    private OnFragmentInteractionListener mListener;

    public Controles() {
        // Required empty public constructor

    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Controles.
     */
    // TODO: Rename and change types and number of parameters
    public static Controles newInstance(String param1, String param2) {
        Controles fragment = new Controles();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }



    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View V = inflater.inflate(R.layout.fragment_controles, container, false);
        c=this.getContext();
        seek=(SeekBar)V.findViewById(R.id.seekBar);
        anterior= (ImageButton)V.findViewById(R.id.imageButton1);
        retroceder= (ImageButton)V.findViewById(R.id.imageButton2);
        stop= (ImageButton)V.findViewById(R.id.imageButton3);
        play= (ImageButton)V.findViewById(R.id.imageButton4);
        avanzar= (ImageButton)V.findViewById(R.id.imageButton5);
        siguiente= (ImageButton)V.findViewById(R.id.imageButton6);

        Anterior();
        Retroceder();
        Stop();
        Play();
        Avanzar();
        Siguiente();


        return V;
    }


    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }

    private void Anterior() {
        anterior.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                seek.setProgress(0);
            }
        });
    }
    private void Retroceder() {
        retroceder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                seek.setProgress(seek.getProgress()-5);
            }
        });
    }
    private void Stop() {
        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                seek.setProgress(0);
            }
        });
    }
    private void Play() {
        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText( c, "Play", Toast.LENGTH_SHORT).show();
            }
        });
    }
    private void Avanzar() {
        avanzar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                seek.setProgress(seek.getProgress()+5);
            }
        });
    }
    private void Siguiente() {
        siguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                seek.setProgress(0);
            }
        });
    }
}
