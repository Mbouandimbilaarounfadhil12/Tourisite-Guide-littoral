package com.touristguide;

import java.util.ArrayList;

public class TouristSiteDetail {
     String name;
     String description;
     int imageResourceId;
     String category;
    public TouristSiteDetail(String name, String description, int imageResourceId,String category) {
        this.name = name;
        this.description = description;
        this.imageResourceId = imageResourceId;
        this.category = category;
    }
    public static ArrayList<TouristSiteDetail> filterByCategory(String category, ArrayList<TouristSiteDetail> touristSites) {
        ArrayList<TouristSiteDetail> filteredSites = new ArrayList<>();
        for (TouristSiteDetail site : touristSites) {
            if (site.category.equalsIgnoreCase(category)) {
                filteredSites.add(site);
            }
        }
        return filteredSites;
    }
}
