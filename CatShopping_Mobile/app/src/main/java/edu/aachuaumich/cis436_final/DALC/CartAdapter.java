package edu.aachuaumich.cis436_final.DALC;


import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

import edu.aachuaumich.cis436_final.Objects.Order;
import edu.aachuaumich.cis436_final.R;
import edu.aachuaumich.cis436_final.Views.Cart;

public class CartAdapter extends ArrayAdapter<Order>
{
    Context context;
    int layoutRes;
    List<Order> orderList;
    private Context mContext;

    public CartAdapter(Context context, int layoutRes, List<Order> orderList)
    {
        super(context, layoutRes, orderList);
        this.context = context;
        this.layoutRes = layoutRes;
        this.orderList = orderList;
        this.mContext=context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent)
    {
        LayoutInflater inflater = LayoutInflater.from(context);

        View view = inflater.inflate(layoutRes, null);

        TextView textItemId = view.findViewById(R.id.itemId);
        TextView textViewName =  view.findViewById(R.id.productName);
        TextView textViewPrice = view.findViewById(R.id.productPrice);
        Button deleteButton = view.findViewById(R.id.btnDelete);

        deleteButton.setOnClickListener(new Button.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                if(mContext instanceof Cart)
                {
                    ViewGroup myGroup = (ViewGroup) v.getParent();
                    TextView textView = myGroup.findViewById(R.id.itemId);

                    String temp = textView.getText().toString();
                    ((Cart)mContext).removeItem(temp);
                }
            }
        });

        Order order = orderList.get(position);

        //fill in views with order information
        String temp = Integer.toString(order.getProductId());
        textItemId.setText(temp);
        textViewName.setText(order.getProductName());
        textViewPrice.setText(order.getPrice());

        return view;
    }


}
