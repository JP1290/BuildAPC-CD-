package com.codingdojo.buildAPC.models;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "builds")
public class Build {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotEmpty(message = "Build name can't be blank")
	@Size(min = 3, max = 64, message = "Build name must be more than 3 characters")
	private String buildName;
	private String CPU;
	private String Motherboard;
	private String CPUCooler;
	private String GPU;
	private String PSU;
	private String RAM;
	private String computerCase;
	@Column(updatable = false)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date createdAt;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date updatedAt;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	private User user;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CPU_id")
	private CPU cpu;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "GPU_id")
	private GPU gpu;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "Motherboard_id")
	private Motherboard motherboard;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "computerCase_id")
	private ComputerCase Computercase;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CPUCooler_id")
	private CPUCooler cpucooler;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PSU_id")
	private PSU psu;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "RAM_id")
	private RAM ram;
	
	
	
	
	public Build() {
	}
	
	public Build(Long id, String buildName, String CPU, String Motherboard, String CPUCooler, String GPU, String PSU, String computerCase, Date createdAt, Date updatedAt, User user, CPU cpu, GPU gpu, Motherboard motherboard, ComputerCase Computercase, RAM ram, PSU psu, CPUCooler cpucooler) {
		this.id = id;
		this.buildName = buildName;
		this.CPU = CPU;
		this.Motherboard = Motherboard;
		this.CPUCooler = CPUCooler;
		this.GPU = GPU;
		this.PSU = PSU;
		this.computerCase = computerCase;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.user = user;
		this.gpu = gpu;
		this.cpu = cpu;
		this.motherboard = motherboard;
		this.cpucooler = cpucooler;
		this.ram = ram;
		this.Computercase = Computercase;
		this.psu = psu;
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String buildName() {
		return buildName;
	}
	
	public void setBuildName(String buildName) {
		this.buildName = buildName;
	}
	
	public String getCpu() {
		return CPU;
	}

	public void setCpu(String CPU) {
		this.CPU = CPU;
	}

	public String getMotherboard() {
		return Motherboard;
	}

	public void setMotherboard(String Motherboard) {
		this.Motherboard = Motherboard;
	}

	public String getCooler() {
		return CPUCooler;
	}

	public void setCooler(String CPUCooler) {
		this.CPUCooler = CPUCooler;
	}

	public String getGpu() {
		return GPU;
	}

	public void setGpu(String GPU) {
		this.GPU = GPU;
	}

	public String getPsu() {
		return PSU;
	}

	public void setPsu(String PSU) {
		this.PSU = PSU;
	}

	public String getRam() {
		return RAM;
	}

	public void setRam(String RAM) {
		this.RAM = RAM;
	}

	public String getComputerCase() {
		return computerCase;
	}

	public void setComputerCase(String computerCase) {
		this.computerCase = computerCase;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	
	
	public String getCPU() {
		return CPU;
	}

	public void setCPU(String cPU) {
		CPU = cPU;
	}

	public String getCPUCooler() {
		return CPUCooler;
	}

	public void setCPUCooler(String cPUCooler) {
		CPUCooler = cPUCooler;
	}

	public String getGPU() {
		return GPU;
	}

	public void setGPU(String gPU) {
		GPU = gPU;
	}

	public String getPSU() {
		return PSU;
	}

	public void setPSU(String pSU) {
		PSU = pSU;
	}

	public String getRAM() {
		return RAM;
	}

	public void setRAM(String rAM) {
		RAM = rAM;
	}

	public ComputerCase getComputercase() {
		return Computercase;
	}

	public void setComputercase(ComputerCase computercase) {
		Computercase = computercase;
	}

	public CPUCooler getCpucooler() {
		return cpucooler;
	}

	public void setCpucooler(CPUCooler cpucooler) {
		this.cpucooler = cpucooler;
	}

	public String getBuildName() {
		return buildName;
	}

	public void setCpu(CPU cpu) {
		this.cpu = cpu;
	}

	public void setGpu(GPU gpu) {
		this.gpu = gpu;
	}

	public void setMotherboard(Motherboard motherboard) {
		this.motherboard = motherboard;
	}

	public void setPsu(PSU psu) {
		this.psu = psu;
	}

	public void setRam(RAM ram) {
		this.ram = ram;
	}

	@PrePersist
	protected void onCreate() {
		this.createdAt = new Date();
	}
	
	@PreUpdate
	protected void onUpdate() {
		this.updatedAt = new Date();
	}
	
}
