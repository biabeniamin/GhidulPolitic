//generated automatically
package com.example.biabe.DatabaseFunctionsGenerator;
import com.example.biabe.DatabaseFunctionsGenerator.Models.*;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import java.util.List;
public class PartidAdapter extends BaseAdapter
{
	List<Partid> partids;
	Context context;
	
	@Override
	public int getCount()
	{
		return partids.size();
	
	}
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent)
	{
		Partid partid;
		TextView partidIdTextBox;
		TextView numeTextBox;
		TextView pozitieTextBox;
		TextView creationTimeTextBox;
		
		partid = getItem(position);
		
		if(null == convertView)
		{
			convertView = LayoutInflater.from(context).inflate(R.layout.partid_view, parent, false);
		}
		
		partidIdTextBox = (TextView) convertView.findViewById(R.id.partidIdTextBox);
		numeTextBox = (TextView) convertView.findViewById(R.id.numeTextBox);
		pozitieTextBox = (TextView) convertView.findViewById(R.id.pozitieTextBox);
		creationTimeTextBox = (TextView) convertView.findViewById(R.id.creationTimeTextBox);
		
		partidIdTextBox.setText(partid.getPartidId().toString());
		numeTextBox.setText(partid.getNume());
		pozitieTextBox.setText(partid.getPozitie().toString());
		creationTimeTextBox.setText(partid.getCreationTime().toString());
		
		return convertView;
	
	}
	
	@Override
	public Partid getItem(int position)
	{
		return partids.get(position);
	
	}
	
	@Override
	public long getItemId(int position)
	{
		return partids.get(position).getPartidId();
	
	}
	
	public PartidAdapter(List<Partid> partids, Context context)
	{
		this.partids = partids;
		this.context = context;
	
	}
	

}
