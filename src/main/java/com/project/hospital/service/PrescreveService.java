package com.project.hospital.service;

import org.springframework.stereotype.Service;

import com.project.hospital.repository.PrescreveRepository;

@Service
public class PrescreveService {
	private PrescreveRepository prescreveRepository;

	public PrescreveService(PrescreveRepository prescreveRepository) {
		super();
		this.prescreveRepository = prescreveRepository;
	}
	
	}
