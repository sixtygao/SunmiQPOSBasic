package com.gll.testmvvm;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;

/**
 * User: highsixty
 * Date: 2020-02-25 10:31
 * email: gaolulin@sunmi.com
 */
public class CommenRecycleViewAdapter<T> extends RecyclerView.Adapter<CommenRecycleViewAdapter.CommenViewHolder> {

    private Context mContext;
    private LayoutInflater layoutInflater;
    private int variableId;
    private List<T> beans;


    public CommenRecycleViewAdapter(Context mContext, LayoutInflater layoutInflater, int variableId, List<T> beans) {
        this.mContext = mContext;
        this.layoutInflater = layoutInflater;
        this.variableId = variableId;
        this.beans = beans;
    }

    @NonNull
    @Override
    public CommenViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        ViewDataBinding dataBinding = DataBindingUtil.inflate(layoutInflater,R.layout.item,parent,false);

        CommenViewHolder viewHolder = new CommenViewHolder(dataBinding.getRoot().getRootView());

        viewHolder.setDataBinding(dataBinding);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CommenRecycleViewAdapter.CommenViewHolder holder, int position) {
        holder.setContent(beans.get(position));
    }

    @Override
    public int getItemCount() {
        return beans.size();
    }



    class CommenViewHolder extends RecyclerView.ViewHolder{

        ViewDataBinding dataBinding ;

        public CommenViewHolder(@NonNull View itemView) {
            super(itemView);
        }

        public void setDataBinding(ViewDataBinding dataBinding) {
            this.dataBinding = dataBinding;
        }


        public void setContent(T t){
            dataBinding.setVariable(variableId,t);
            dataBinding.executePendingBindings();
        }
    }
}
