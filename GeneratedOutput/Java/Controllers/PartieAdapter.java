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
public class PartieAdapter extends BaseAdapter
{
	List<Partie> parties;
	Context context;
	
	@Override
	public int getCount()
	{
		return parties.size();
	
	}
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent)
	{
		Partie partie;
		TextView partieIdTextBox;
		TextView nameTextBox;
		TextView positionTextBox;
		TextView creationTimeTextBox;
		
		partie = getItem(position);
		
		if(null == convertView)
		{
			convertView = LayoutInflater.from(context).inflate(R.layout.partie_view, parent, false);
		}
		
		partieIdTextBox = (TextView) convertView.findViewById(R.id.partieIdTextBox);
		nameTextBox = (TextView) convertView.findViewById(R.id.nameTextBox);
		positionTextBox = (TextView) convertView.findViewById(R.id.positionTextBox);
		creationTimeTextBox = (TextView) convertView.findViewById(R.id.creationTimeTextBox);
		
		partieIdTextBox.setText(partie.getPartieId().toString());
		nameTextBox.setText(partie.getName());
		positionTextBox.setText(partie.getPosition().toString());
		creationTimeTextBox.setText(partie.getCreationTime().toString());
		
		return convertView;
	
	}
	
	@Override
	public Partie getItem(int position)
	{
		return parties.get(position);
	
	}
	
	@Override
	public long getItemId(int position)
	{
		return parties.get(position).getPartieId();
	
	}
	
	public PartieAdapter(List<Partie> parties, Context context)
	{
		this.parties = parties;
		this.context = context;
	
	}
	

}
