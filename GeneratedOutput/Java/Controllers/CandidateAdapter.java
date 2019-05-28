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
public class CandidateAdapter extends BaseAdapter
{
	List<Candidate> candidates;
	Context context;
	
	@Override
	public int getCount()
	{
		return candidates.size();
	
	}
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent)
	{
		Candidate candidate;
		TextView candidateIdTextBox;
		TextView nameTextBox;
		TextView emailTextBox;
		TextView passwordTextBox;
		TextView descriptionTextBox;
		TextView roleTextBox;
		TextView creationTimeTextBox;
		
		candidate = getItem(position);
		
		if(null == convertView)
		{
			convertView = LayoutInflater.from(context).inflate(R.layout.candidate_view, parent, false);
		}
		
		candidateIdTextBox = (TextView) convertView.findViewById(R.id.candidateIdTextBox);
		nameTextBox = (TextView) convertView.findViewById(R.id.nameTextBox);
		emailTextBox = (TextView) convertView.findViewById(R.id.emailTextBox);
		passwordTextBox = (TextView) convertView.findViewById(R.id.passwordTextBox);
		descriptionTextBox = (TextView) convertView.findViewById(R.id.descriptionTextBox);
		roleTextBox = (TextView) convertView.findViewById(R.id.roleTextBox);
		creationTimeTextBox = (TextView) convertView.findViewById(R.id.creationTimeTextBox);
		
		candidateIdTextBox.setText(candidate.getCandidateId().toString());
		nameTextBox.setText(candidate.getName());
		emailTextBox.setText(candidate.getEmail());
		passwordTextBox.setText(candidate.getPassword());
		descriptionTextBox.setText(candidate.getDescription());
		roleTextBox.setText(candidate.getRole());
		creationTimeTextBox.setText(candidate.getCreationTime().toString());
		
		return convertView;
	
	}
	
	@Override
	public Candidate getItem(int position)
	{
		return candidates.get(position);
	
	}
	
	@Override
	public long getItemId(int position)
	{
		return candidates.get(position).getCandidateId();
	
	}
	
	public CandidateAdapter(List<Candidate> candidates, Context context)
	{
		this.candidates = candidates;
		this.context = context;
	
	}
	

}
