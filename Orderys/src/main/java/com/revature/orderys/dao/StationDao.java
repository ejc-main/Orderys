package com.revature.orderys.dao;

import java.util.List;

import com.revature.orderys.bean.Business;
import com.revature.orderys.bean.Station;

public interface StationDao {


	List<Station> getAllStations();

	void createStation(Station s);

	Station getStationById(long id);

	void updateStation(Station s);

	void deleteStation(Station s);

	List<Station> getAllStationsByBusiness(Business b);

}