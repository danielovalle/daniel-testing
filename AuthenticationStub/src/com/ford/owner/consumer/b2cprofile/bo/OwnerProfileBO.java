package com.ford.owner.consumer.b2cprofile.bo;

import java.io.Serializable;
import java.util.List;

public class OwnerProfileBO
  implements Serializable
{
  private static final String CLASS_NAME = OwnerProfileBO.class.getName();

  private String firstName;
  private String lastName;
  private String middleInitial;
  private String namePrefix;
  private String nameSuffix;
  private String userName;
  private String password;
  private String address1;
  private String address2;
  private String reminderQuestion;
  private String reminderAnswer;
  private String city;
  private String state;
  private String country;
  private String postalCode;
  private String contactNumber;
  private String alternateContactNumber;
  private String emailID;
  private String emailPrivPref;
  private String userGuid;
  private String consumerID;
  private String passwordReset;
  private String dealerProcessFlag;
  private String languageCode;
  private List<String> unmatchedFields;
  private String oarAccountNo;
  private String fcFinLabel;
  private String consumerType;
  private String lastLoginTime;
  private String loginCount;
  private boolean syncRegistered = false;
  private boolean hasFordCreditProfile = false;
  private String vhrNotificationFlag;
  private String vhrUrgentNotificationsFlag;
  private String vhrNotificationType;

  public String getOarAccountNo()
  {
    return this.oarAccountNo;
  }

  public void setOarAccountNo(String oarAccountNo)
  {
    this.oarAccountNo = oarAccountNo;
  }

  public String getDealerProcessFlag()
  {
    return this.dealerProcessFlag;
  }

  public void setDealerProcessFlag(String dealerProcessFlag)
  {
    this.dealerProcessFlag = dealerProcessFlag;
  }

  public String getAddress1()
  {
    return this.address1;
  }

  public void setAddress1(String address1)
  {
    this.address1 = address1;
  }

  public String getAddress2()
  {
    return this.address2;
  }

  public void setAddress2(String address2)
  {
    this.address2 = address2;
  }

  public String getAlternateContactNumber()
  {
    return this.alternateContactNumber;
  }

  public void setAlternateContactNumber(String alternateContactNumber)
  {
    this.alternateContactNumber = alternateContactNumber;
  }

  public String getCity()
  {
    return this.city;
  }

  public void setCity(String city)
  {
    this.city = city;
  }

  public String getConsumerID()
  {
    return this.consumerID;
  }

  public void setConsumerID(String consumerID)
  {
    this.consumerID = consumerID;
  }

  public String getContactNumber()
  {
    return this.contactNumber;
  }

  public void setContactNumber(String contactNumber)
  {
    this.contactNumber = contactNumber;
  }

  public String getCountry()
  {
    return this.country;
  }

  public void setCountry(String country)
  {
    this.country = country;
  }

  public String getEmailID()
  {
    return this.emailID;
  }

  public void setEmailID(String emailID)
  {
    this.emailID = emailID;
  }

  public String getEmailPrivPref()
  {
    return this.emailPrivPref;
  }

  public void setEmailPrivPref(String emailPrivPref)
  {
    this.emailPrivPref = emailPrivPref;
  }

  public String getFirstName()
  {
    return this.firstName;
  }

  public void setFirstName(String firstName)
  {
    this.firstName = firstName;
  }

  public String getLanguageCode()
  {
    return this.languageCode;
  }

  public void setLanguageCode(String languageCode)
  {
    this.languageCode = languageCode;
  }

  public String getLastName()
  {
    return this.lastName;
  }

  public void setLastName(String lastName)
  {
    this.lastName = lastName;
  }

  public String getMiddleInitial()
  {
    return this.middleInitial;
  }

  public void setMiddleInitial(String middleInitial)
  {
    this.middleInitial = middleInitial;
  }

  public String getNamePrefix()
  {
    return this.namePrefix;
  }

  public void setNamePrefix(String namePrefix)
  {
    this.namePrefix = namePrefix;
  }

  public String getNameSuffix()
  {
    return this.nameSuffix;
  }

  public void setNameSuffix(String nameSuffix)
  {
    this.nameSuffix = nameSuffix;
  }

  public String getPassword()
  {
    return this.password;
  }

  public void setPassword(String password)
  {
    this.password = password;
  }

  public String getPasswordReset()
  {
    return this.passwordReset;
  }

  public void setPasswordReset(String passwordReset)
  {
    this.passwordReset = passwordReset;
  }

  public String getPostalCode()
  {
    return this.postalCode;
  }

  public void setPostalCode(String postalCode)
  {
    this.postalCode = postalCode;
  }

  public String getReminderAnswer()
  {
    return this.reminderAnswer;
  }

  public void setReminderAnswer(String reminderAnswer)
  {
    this.reminderAnswer = reminderAnswer;
  }

  public String getReminderQuestion()
  {
    return this.reminderQuestion;
  }

  public void setReminderQuestion(String reminderQuestion)
  {
    this.reminderQuestion = reminderQuestion;
  }

  public String getState()
  {
    return this.state;
  }

  public void setState(String state)
  {
    this.state = state;
  }

  public List<String> getUnmatchedFields()
  {
    return this.unmatchedFields;
  }

  public void setUnmatchedFields(List<String> unmatchedFields)
  {
    this.unmatchedFields = unmatchedFields;
  }

  public String getUserGuid()
  {
    return this.userGuid;
  }

  public void setUserGuid(String userGuid)
  {
    this.userGuid = userGuid;
  }

  public String getUserName()
  {
    return this.userName;
  }

  public void setUserName(String userName)
  {
    this.userName = userName;
  }

  public String getFcFinLabel()
  {
    return this.fcFinLabel;
  }

  public void setFcFinLabel(String fcFinLabel)
  {
    this.fcFinLabel = fcFinLabel;
  }

  public String getConsumerType()
  {
    return this.consumerType;
  }

  public void setConsumerType(String consumerType)
  {
    this.consumerType = consumerType;
  }

  public String getLastLoginTime()
  {
    return this.lastLoginTime;
  }

  public void setLastLoginTime(String lastLoginTime)
  {
    this.lastLoginTime = lastLoginTime;
  }

  public String getLoginCount()
  {
    return this.loginCount;
  }

  public void setLoginCount(String loginCount)
  {
    this.loginCount = loginCount;
  }

  public boolean getSyncRegistered()
  {
    return this.syncRegistered;
  }

  public void setSyncRegistered(boolean syncRegistered)
  {
    this.syncRegistered = syncRegistered;
  }

  public boolean isHasFordCreditProfile()
  {
    return this.hasFordCreditProfile;
  }

  public void setHasFordCreditProfile(boolean hasFordCreditProfile)
  {
    this.hasFordCreditProfile = hasFordCreditProfile;
  }

  public String getVhrNotificationType()
  {
    return this.vhrNotificationType;
  }

  public void setVhrNotificationType(String vhrNotificationType)
  {
    this.vhrNotificationType = vhrNotificationType;
  }

  public String getVhrNotificationFlag()
  {
    return this.vhrNotificationFlag;
  }

  public void setVhrNotificationFlag(String vhrNotificationFlag)
  {
    this.vhrNotificationFlag = vhrNotificationFlag;
  }

  public String getVhrUrgentNotificationsFlag()
  {
    return this.vhrUrgentNotificationsFlag;
  }

  public void setVhrUrgentNotificationsFlag(String vhrUrgentNotificationsFlag)
  {
    this.vhrUrgentNotificationsFlag = vhrUrgentNotificationsFlag;
  }
}