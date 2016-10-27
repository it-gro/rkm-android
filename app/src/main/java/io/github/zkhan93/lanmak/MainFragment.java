package io.github.zkhan93.lanmak;

import android.app.Fragment;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TableLayout;
import android.widget.Toast;

import io.github.zkhan93.lanmak.MainActivity.SetNetwork;
import io.github.zkhan93.lanmak.utility.Constants;
import io.github.zkhan93.lanmak.utility.MyTextWatcher;
import io.github.zkhan93.lanmak.utility.SpecialButtons;

public class MainFragment extends Fragment implements MyTextWatcherClblk {
    public static final String TAG = MainFragment.class.getSimpleName();

    private EditText edt;
    static boolean setup = false;
    private OutputStreamHandler outputStreamHandler;

    public MainFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main, container,
                false);
        edt = (EditText) rootView.findViewById(R.id.editText);
        edt.addTextChangedListener(new MyTextWatcher(this));
        return rootView;
    }

    @Override
    public void onStart() {
        super.onStart();
        outputStreamHandler = (OutputStreamHandler) getActivity();
        if (((MainActivity) getActivity()).specialButtons == null)
            ((MainActivity) getActivity()).specialButtons = (TableLayout) getActivity()
                    .findViewById(R.id.SpecialButtons);

        ((MainActivity) getActivity()).specialButtons
                .setVisibility(((MainActivity) getActivity()).sbutton_visible ? View.VISIBLE
                        : View.GONE);
        if (!setup) {
            SharedPreferences spf = PreferenceManager
                    .getDefaultSharedPreferences
                            (getActivity().getApplicationContext());
            new SetNetwork(getActivity().getApplicationContext(), (OutputStreamHandler) getActivity(), spf
                    .getString("server_ip", Constants.SERVER_IP), spf
                    .getString("port", String.valueOf(Constants.PORT)));
            setup = true;
        }
        setLongPressInfo();

    }

    @Override
    public void sendKey(String cmd) {
        outputStreamHandler.send(Constants.ZERO + Constants.COLON
                + Constants.ZERO + Constants.COLON + cmd);
    }

    public void setLongPressInfo() {
        ImageButton b11, b12, b13, b14, b15, b16, b21, b22, b23, b24, b25, b26;
        MainActivity act = (MainActivity) getActivity();
        b11 = (ImageButton) act.findViewById(R.id.buttonspecial11);
        b12 = (ImageButton) act.findViewById(R.id.buttonspecial12);
        b13 = (ImageButton) act.findViewById(R.id.buttonspecial13);
        b14 = (ImageButton) act.findViewById(R.id.buttonspecial14);
        b15 = (ImageButton) act.findViewById(R.id.buttonspecial15);
        b16 = (ImageButton) act.findViewById(R.id.buttonspecial16);
        b21 = (ImageButton) act.findViewById(R.id.buttonspecial21);
        b22 = (ImageButton) act.findViewById(R.id.buttonspecial22);
        b23 = (ImageButton) act.findViewById(R.id.buttonspecial23);
        b24 = (ImageButton) act.findViewById(R.id.buttonspecial24);
        b25 = (ImageButton) act.findViewById(R.id.buttonspecial25);
        b26 = (ImageButton) act.findViewById(R.id.buttonspecial26);
        LongClickInfo linfo = new LongClickInfo();
        b11.setOnLongClickListener(linfo);
        b12.setOnLongClickListener(linfo);
        b13.setOnLongClickListener(linfo);
        b14.setOnLongClickListener(linfo);
        b15.setOnLongClickListener(linfo);
        b16.setOnLongClickListener(linfo);
        b21.setOnLongClickListener(linfo);
        b22.setOnLongClickListener(linfo);
        b23.setOnLongClickListener(linfo);
        b24.setOnLongClickListener(linfo);
        b25.setOnLongClickListener(linfo);
        b26.setOnLongClickListener(linfo);
    }

    public class LongClickInfo implements OnLongClickListener {
        @Override
        public boolean onLongClick(View v) {
            switch (v.getId()) {
                case R.id.buttonspecial11:
                    Toast.makeText(getActivity(), SpecialButtons.Button11.name,
                            Toast.LENGTH_SHORT).show();
                    break;
                case R.id.buttonspecial12:
                    Toast.makeText(getActivity(), SpecialButtons.Button12.name,
                            Toast.LENGTH_SHORT).show();
                    break;
                case R.id.buttonspecial13:
                    Toast.makeText(getActivity(), SpecialButtons.Button13.name,
                            Toast.LENGTH_SHORT).show();
                    break;
                case R.id.buttonspecial14:
                    Toast.makeText(getActivity(), SpecialButtons.Button14.name,
                            Toast.LENGTH_SHORT).show();
                    break;
                case R.id.buttonspecial15:
                    Toast.makeText(getActivity(), SpecialButtons.Button15.name,
                            Toast.LENGTH_SHORT).show();
                    break;
                case R.id.buttonspecial16:
                    Toast.makeText(getActivity(), SpecialButtons.Button16.name,
                            Toast.LENGTH_SHORT).show();
                    break;
                case R.id.buttonspecial21:
                    Toast.makeText(getActivity(), SpecialButtons.Button21.name,
                            Toast.LENGTH_SHORT).show();
                    break;
                case R.id.buttonspecial22:
                    Toast.makeText(getActivity(), SpecialButtons.Button22.name,
                            Toast.LENGTH_SHORT).show();
                    break;
                case R.id.buttonspecial23:
                    Toast.makeText(getActivity(), SpecialButtons.Button23.name,
                            Toast.LENGTH_SHORT).show();
                    break;
                case R.id.buttonspecial24:
                    Toast.makeText(getActivity(), SpecialButtons.Button24.name,
                            Toast.LENGTH_SHORT).show();
                    break;
                case R.id.buttonspecial25:
                    Toast.makeText(getActivity(), SpecialButtons.Button25.name,
                            Toast.LENGTH_SHORT).show();
                    break;
                case R.id.buttonspecial26:
                    Toast.makeText(getActivity(), SpecialButtons.Button26.name,
                            Toast.LENGTH_SHORT).show();
                    break;

            }
            return true;
        }
    }
}