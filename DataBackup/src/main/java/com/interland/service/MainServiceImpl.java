package com.interland.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.interland.dao.MainDao;
import com.interland.entities.Backup;
import com.interland.entities.Main;

@Service
public class MainServiceImpl implements MainService {

	@Autowired
	MainDao dao;

	@Override
	public String dataGeneratorService() {
		try {
			for (int i = 1; i <= 20; i++) {
				LocalDate ldObj = LocalDate.of(2019, 7, i % 28);
				Main main = new Main(ldObj);
				dao.insert(main);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		return "done";
	}

	@Override
	public List<Main> doBackup() {
		int pageNumber = 1;
		int pageSize = 10;
		int processedRecords = 0;
		Long count = dao.getCountRecordsByDate();
		List<Main> result = null;
		
		try {
			while (pageNumber < count.intValue()) {
				result = dao.findRecordsByDate(0,pageSize);
				for (Main m : result) {
					Backup b = new Backup();
					b.setId(m.getId());
					b.setDate(m.getDate());
					dao.insert(b);
					dao.delete(m);
				}
				processedRecords += result.size();
				System.out.println("pageNumber: "+pageNumber+", resultSize: "+result.size()+", processedRecordsCount: "+processedRecords+", toalRecordsCount: "+count);
				pageNumber += pageSize;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}

}
