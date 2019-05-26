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
public class CandidatAdapter extends BaseAdapter
{
	List<Candidat> candidats;
	Context context;
	
	@Override
	public int getCount()
	{
		return candidats.size();
	
	}
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent)
	{
		Candidat candidat;
		TextView candidatIdTextBox;
		TextView numeTextBox;
		TextView descriereTextBox;
		TextView functieTextBox;
		TextView creationTimeTextBox;
		
		candidat = getItem(position);
		
		if(null == convertView)
		{
			convertView = LayoutInflater.from(context).inflate(R.layout.candidat_view, parent, false);
		}
		
		candidatIdTextBox = (TextView) convertView.findViewById(R.id.candidatIdTextBox);
		numeTextBox = (TextView) convertView.findViewById(R.id.numeTextBox);
		descriereTextBox = (TextView) convertView.findViewById(R.id.descriereTextBox);
		functieTextBox = (TextView) convertView.findViewById(R.id.functieTextBox);
		creationTimeTextBox = (TextView) convertView.findViewById(R.id.creationTimeTextBox);
		
		candidatIdTextBox.setText(candidat.getCandidatId().toString());
		numeTextBox.setText(candidat.getNume());
		descriereTextBox.setText(candidat.getDescriere());
		functieTextBox.setText(candidat.getFunctie());
		creationTimeTextBox.setText(candidat.getCreationTime().toString());
		
		return convertView;
	
	}
	
	@Override
	public Candidat getItem(int position)
	{
		return candidats.get(position);
	
	}
	
	@Override
	public long getItemId(int position)
	{
		return candidats.get(position).getCandidatId();
	
	}
	
	public CandidatAdapter(List<Candidat> candidats, Context context)
	{
		this.candidats = candidats;
		this.context = context;
	
	}
	

}
