package com.dhm.uniontestapp;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.dhm.uniontestapp.db.RestApi;
import com.dhm.uniontestapp.db.RewardModel;
import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ViewListener;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
public class RewardsFragment extends Fragment {

    private static final String TAG = "RewardsFragment";

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    ArrayList<View> viewsList =new ArrayList<>();
    private Button btnDisplay;
    private Button btnGoal;
    private Button btnPartner;
    private ArrayList<String> mImageUrls = new ArrayList<>();
    private ArrayList<String> mAddress = new ArrayList<>();
    private ArrayList<String> description = new ArrayList<>();
    private ArrayList<String> expireDate = new ArrayList<>();
    private static RestApi restApi = new RestApi();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.rewards_fragment, container, false);
        CarouselView carouselView = rootView.findViewById(R.id.carouselView);
        View inflatedView = getLayoutInflater().inflate(R.layout.top_bar_component, null);
        View cardCompo = getLayoutInflater().inflate(R.layout.card_component, null);
        CardView card = cardCompo.findViewById(R.id.card_compo_view);
        card.setBackgroundResource(R.drawable.ic_launcher_foreground);

        btnDisplay = rootView.findViewById(R.id.btnAll);
        btnGoal = rootView.findViewById(R.id.btnGoal);
        btnPartner = rootView.findViewById(R.id.btnPartner);
        View slideComponent =  inflatedView.findViewById(R.id.slideCompo);
        View slideComponent2 =  inflatedView.findViewById(R.id.slideCompo);
        View slideComponent3 =  inflatedView.findViewById(R.id.slideCompo);
        View slideComponent4 = inflatedView.findViewById(R.id.slideCompo);
        View slideComponent5 =  inflatedView.findViewById(R.id.slideCompo);
        View slideComponent6 =  inflatedView.findViewById(R.id.slideCompo);
        viewsList.add(slideComponent);
        viewsList.add(slideComponent2);
        viewsList.add(slideComponent3);
        viewsList.add(slideComponent4);
        viewsList.add(slideComponent5);
        viewsList.add(slideComponent6);
        carouselView.setPageCount(viewsList.size());
        carouselView.pauseCarousel();
        carouselView.setViewListener(viewListener);
        addListenerOnButton();
        Call<List<RewardModel>> allUsers = RestApi.sendRequestGet().getAllUsers();

        allUsers.enqueue(new Callback<List<RewardModel>>() {
            @Override
            public void onResponse(Call<List<RewardModel>> call, Response<List<RewardModel>> response) {

                if(response.isSuccessful()){
                    List<RewardModel> userResponses = response.body();
                    Log.e(TAG, "onResponse: "+userResponses.size());
                    for (RewardModel r : userResponses)
                    {
                        mImageUrls.add(r.getImage());
                        mAddress.add(r.getTitle());
                        description.add(r.getSubTitle().substring(0,20));
                        if(r.getExpireDate()!=null){
                            expireDate.add("Expires on: "+r.getExpireDate().substring(0,10));
                        }else{
                            expireDate.add("No expiration date");
                        }
                    }

                    LinearLayoutManager layoutManager = new LinearLayoutManager
                            (getContext(), LinearLayoutManager.HORIZONTAL, false);
                    RecyclerView view = rootView.findViewById(R.id.recyclerViewId1);
                    view.setLayoutManager(layoutManager);
                    StoryListAdaptor storyListAdaptor = new StoryListAdaptor(mImageUrls, mAddress,description,expireDate,
                            getContext());
                    view.setNestedScrollingEnabled(false);
                    view.setAdapter(storyListAdaptor);

                    LinearLayoutManager layoutManagerRewards = new LinearLayoutManager
                            (getContext(), LinearLayoutManager.HORIZONTAL, false);
                    RecyclerView viewReward = rootView.findViewById(R.id.recyclerViewId2);
                    viewReward.setLayoutManager(layoutManagerRewards);
                    StoryListAdaptor rewardListAdapter = new StoryListAdaptor(mImageUrls, mAddress,description,expireDate,
                            getContext());
                    viewReward.setNestedScrollingEnabled(false);
                    viewReward.setAdapter(rewardListAdapter);
                }
            }

            @Override
            public void onFailure(@NonNull Call<List<RewardModel>> call, Throwable t) {
                Log.e("failure",t.getLocalizedMessage());
            }
        });

        return rootView;
    }

    ViewListener viewListener = position -> viewsList.get(position);

    public void addListenerOnButton() {

        btnDisplay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnDisplay.setTextColor(getResources().getColor(R.color.yellow_text_btn));
                btnDisplay.setBackgroundColor(getResources().getColor(R.color.purple_400));
                btnGoal.setTextColor(getResources().getColor(R.color.btnText));
                btnGoal.setBackgroundColor(getResources().getColor(R.color.white));
                btnPartner.setTextColor(getResources().getColor(R.color.btnText));
                btnPartner.setBackgroundColor(getResources().getColor(R.color.white));
            }
        });

        btnGoal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnGoal.setTextColor(getResources().getColor(R.color.yellow_text_btn));
                btnGoal.setBackgroundColor(getResources().getColor(R.color.purple_400));

                btnDisplay.setTextColor(getResources().getColor(R.color.btnText));
                btnDisplay.setBackgroundColor(getResources().getColor(R.color.white));
                btnPartner.setTextColor(getResources().getColor(R.color.btnText));
                btnPartner.setBackgroundColor(getResources().getColor(R.color.white));
            }
        });

        btnPartner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnPartner.setTextColor(getResources().getColor(R.color.yellow_text_btn));
                btnPartner.setBackgroundColor(getResources().getColor(R.color.purple_400));

                btnGoal.setTextColor(getResources().getColor(R.color.btnText));
                btnGoal.setBackgroundColor(getResources().getColor(R.color.white));
                btnDisplay.setTextColor(getResources().getColor(R.color.btnText));
                btnDisplay.setBackgroundColor(getResources().getColor(R.color.white));
            }
        });

    }
}
