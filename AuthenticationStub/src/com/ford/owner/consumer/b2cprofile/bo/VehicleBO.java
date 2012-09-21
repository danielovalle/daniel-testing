package com.ford.owner.consumer.b2cprofile.bo;

import java.io.Serializable;

public class VehicleBO
  implements Serializable
{
  private static final String CLASS_NAME = VehicleBO.class.getName();

  private String vin;
  private String vehicleID;
  private int latestMileage = -1;
  private int estimatedMileage = -1;
  private int averageDailyMiles = -1;
  private int userProvidedMileage = -1;
  private String year;
  private String make;
  private String model;
  private String series;
  private String assignedDealer;
  private String serviceDealer;
  private String salesDealer;
  private String preferredDealer;
  private String transmission;
  private String fuel;
  private String cylinders;
  private boolean isFleet;
  private String fleetName;
  private boolean isCPO;
  private int drivingConditions;
  private String vhrStatus;
  private String vhrReady;
  private boolean isOwnedFlag;
  private boolean isSyncEquipped;
  private String nickName;
  private String driveTrain;
  private String vehicleRegistrationDate;
  private String vhrReadyDate;
  private String purchaseDate;
  private String disposalDate;
  private String vhrNotificationStatus;
  private String vhrUrgentNotificationStatus;
  private String vhrNotificationDate;
  private String vhrUrgentNotificationDate;
  private int configId = -1;

  public String getDriveTrain()
  {
    return this.driveTrain;
  }

  public void setDriveTrain(String driveTrain)
  {
    this.driveTrain = driveTrain;
  }

  public String getNickName()
  {
    return this.nickName;
  }

  public void setNickName(String nickName)
  {
    this.nickName = nickName;
  }

  public String getAssignedDealer()
  {
    return this.assignedDealer;
  }

  public void setAssignedDealer(String assignedDealer)
  {
    this.assignedDealer = assignedDealer;
  }

  public int getAverageDailyMiles()
  {
    return this.averageDailyMiles;
  }

  public void setAverageDailyMiles(int averageDailyMiles)
  {
    this.averageDailyMiles = averageDailyMiles;
  }

  public String getCylinders()
  {
    return this.cylinders;
  }

  public void setCylinders(String cylinders)
  {
    this.cylinders = cylinders;
  }

  public int getDrivingConditions()
  {
    return this.drivingConditions;
  }

  public void setDrivingConditions(int drivingConditions)
  {
    this.drivingConditions = drivingConditions;
  }

  public int getEstimatedMileage()
  {
    return this.estimatedMileage;
  }

  public void setEstimatedMileage(int estimatedMileage)
  {
    this.estimatedMileage = estimatedMileage;
  }

  public String getFleetName()
  {
    return this.fleetName;
  }

  public void setFleetName(String fleetName)
  {
    this.fleetName = fleetName;
  }

  public String getFuel()
  {
    return this.fuel;
  }

  public void setFuel(String fuel)
  {
    this.fuel = fuel;
  }

  public boolean isCPO()
  {
    return this.isCPO;
  }

  public void setCPO(boolean isCPO)
  {
    this.isCPO = isCPO;
  }

  public boolean isFleet()
  {
    return this.isFleet;
  }

  public void setFleet(boolean isFleet)
  {
    this.isFleet = isFleet;
  }

  public boolean isOwnedFlag()
  {
    return this.isOwnedFlag;
  }

  public void setOwnedFlag(boolean isOwnedFlag)
  {
    this.isOwnedFlag = isOwnedFlag;
  }

  public boolean isSyncEquipped()
  {
    return this.isSyncEquipped;
  }

  public void setSyncEquipped(boolean isSyncEquipped)
  {
    this.isSyncEquipped = isSyncEquipped;
  }

  public int getLatestMileage()
  {
    return this.latestMileage;
  }

  public void setLatestMileage(int latestMileage)
  {
    this.latestMileage = latestMileage;
  }

  public String getMake()
  {
    return this.make;
  }

  public void setMake(String make)
  {
    this.make = make;
  }

  public String getModel()
  {
    return this.model;
  }

  public void setModel(String model)
  {
    this.model = model;
  }

  public String getSalesDealer()
  {
    return this.salesDealer;
  }

  public void setSalesDealer(String salesDealer)
  {
    this.salesDealer = salesDealer;
  }

  public String getSeries()
  {
    return this.series;
  }

  public void setSeries(String series)
  {
    this.series = series;
  }

  public String getServiceDealer()
  {
    return this.serviceDealer;
  }

  public void setServiceDealer(String serviceDealer)
  {
    this.serviceDealer = serviceDealer;
  }

  public String getTransmission()
  {
    return this.transmission;
  }

  public void setTransmission(String transmission)
  {
    this.transmission = transmission;
  }

  public String getVehicleID()
  {
    return this.vehicleID;
  }

  public void setVehicleID(String vehicleID)
  {
    this.vehicleID = vehicleID;
  }

  public String getVhrReady()
  {
    return this.vhrReady;
  }

  public void setVhrReady(String vhrReady)
  {
    this.vhrReady = vhrReady;
  }

  public String getVhrStatus()
  {
    return this.vhrStatus;
  }

  public void setVhrStatus(String vhrStatus)
  {
    this.vhrStatus = vhrStatus;
  }

  public String getVin()
  {
    return this.vin;
  }

  public void setVin(String vin)
  {
    this.vin = vin;
  }

  public String getYear()
  {
    return this.year;
  }

  public void setYear(String year)
  {
    this.year = year;
  }

  public String getPreferredDealer()
  {
    return this.preferredDealer;
  }

  public void setPreferredDealer(String preferredDealer)
  {
    this.preferredDealer = preferredDealer;
  }

  public int getUserProvidedMileage()
  {
    return this.userProvidedMileage;
  }

  public void setUserProvidedMileage(int userProvidedMileage)
  {
    this.userProvidedMileage = userProvidedMileage;
  }

  public String getVehicleRegistrationDate()
  {
    return this.vehicleRegistrationDate;
  }

  public void setVehicleRegistrationDate(String vehicleRegistrationDate)
  {
    this.vehicleRegistrationDate = vehicleRegistrationDate;
  }

  public String getVhrReadyDate()
  {
    return this.vhrReadyDate;
  }

  public void setVhrReadyDate(String vhrReadyDate)
  {
    this.vhrReadyDate = vhrReadyDate;
  }

  public String getPurchaseDate()
  {
    return this.purchaseDate;
  }

  public void setPurchaseDate(String purchaseDate)
  {
    this.purchaseDate = purchaseDate;
  }

  public String getDisposalDate()
  {
    return this.disposalDate;
  }

  public void setDisposalDate(String disposalDate)
  {
    this.disposalDate = disposalDate;
  }

  public String getVhrNotificationStatus()
  {
    return this.vhrNotificationStatus;
  }

  public void setVhrNotificationStatus(String vhrNotificationStatus)
  {
    this.vhrNotificationStatus = vhrNotificationStatus;
  }

  public String getVhrUrgentNotificationStatus()
  {
    return this.vhrUrgentNotificationStatus;
  }

  public void setVhrUrgentNotificationStatus(String vhrUrgentNotificationStatus)
  {
    this.vhrUrgentNotificationStatus = vhrUrgentNotificationStatus;
  }

  public String getVhrNotificationDate()
  {
    return this.vhrNotificationDate;
  }

  public void setVhrNotificationDate(String vhrNotificationDate)
  {
    this.vhrNotificationDate = vhrNotificationDate;
  }

  public String getVhrUrgentNotificationDate()
  {
    return this.vhrUrgentNotificationDate;
  }

  public void setVhrUrgentNotificationDate(String vhrUrgentNotificationDate)
  {
    this.vhrUrgentNotificationDate = vhrUrgentNotificationDate;
  }

  public int getConfigId()
  {
    return this.configId;
  }

  public void setConfigId(int configId)
  {
    this.configId = configId;
  }
}