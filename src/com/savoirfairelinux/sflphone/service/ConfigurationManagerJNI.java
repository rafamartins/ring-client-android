/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 2.0.8
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package com.savoirfairelinux.sflphone.service;

public class ConfigurationManagerJNI {
  private long swigCPtr;
  protected boolean swigCMemOwn;

  protected ConfigurationManagerJNI(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  protected static long getCPtr(ConfigurationManagerJNI obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if (swigCPtr != 0) {
      if (swigCMemOwn) {
        swigCMemOwn = false;
        SFLPhoneserviceJNI.delete_ConfigurationManagerJNI(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

  public StringMap getIp2IpDetails() {
    return new StringMap(SFLPhoneserviceJNI.ConfigurationManagerJNI_getIp2IpDetails(swigCPtr, this), true);
  }

  public StringMap getAccountDetails(String accountID) {
    return new StringMap(SFLPhoneserviceJNI.ConfigurationManagerJNI_getAccountDetails(swigCPtr, this, accountID), true);
  }

  public StringMap getTlsSettingsDefault() {
    return new StringMap(SFLPhoneserviceJNI.ConfigurationManagerJNI_getTlsSettingsDefault(swigCPtr, this), true);
  }

  public StringMap getTlsSettings() {
    return new StringMap(SFLPhoneserviceJNI.ConfigurationManagerJNI_getTlsSettings(swigCPtr, this), true);
  }

  public void setTlsSettings(StringMap details) {
    SFLPhoneserviceJNI.ConfigurationManagerJNI_setTlsSettings(swigCPtr, this, StringMap.getCPtr(details), details);
  }

  public void setAccountDetails(String accountID, StringMap details) {
    SFLPhoneserviceJNI.ConfigurationManagerJNI_setAccountDetails(swigCPtr, this, accountID, StringMap.getCPtr(details), details);
  }

  public void sendRegister(String accountID, boolean enable) {
    SFLPhoneserviceJNI.ConfigurationManagerJNI_sendRegister(swigCPtr, this, accountID, enable);
  }

  public void registerAllAccounts() {
    SFLPhoneserviceJNI.ConfigurationManagerJNI_registerAllAccounts(swigCPtr, this);
  }

  public StringMap getAccountTemplate() {
    return new StringMap(SFLPhoneserviceJNI.ConfigurationManagerJNI_getAccountTemplate(swigCPtr, this), true);
  }

  public String addAccount(StringMap details) {
    return SFLPhoneserviceJNI.ConfigurationManagerJNI_addAccount(swigCPtr, this, StringMap.getCPtr(details), details);
  }

  public void removeAccount(String accoundID) {
    SFLPhoneserviceJNI.ConfigurationManagerJNI_removeAccount(swigCPtr, this, accoundID);
  }

  public StringVect getAccountList() {
    return new StringVect(SFLPhoneserviceJNI.ConfigurationManagerJNI_getAccountList(swigCPtr, this), true);
  }

  public SWIGTYPE_p_std__vectorT_int32_t_t getAudioCodecList() {
    return new SWIGTYPE_p_std__vectorT_int32_t_t(SFLPhoneserviceJNI.ConfigurationManagerJNI_getAudioCodecList(swigCPtr, this), true);
  }

  public StringVect getSupportedTlsMethod() {
    return new StringVect(SFLPhoneserviceJNI.ConfigurationManagerJNI_getSupportedTlsMethod(swigCPtr, this), true);
  }

  public StringVect getAudioCodecDetails(SWIGTYPE_p_int32_t payload) {
    return new StringVect(SFLPhoneserviceJNI.ConfigurationManagerJNI_getAudioCodecDetails(swigCPtr, this, SWIGTYPE_p_int32_t.getCPtr(payload)), true);
  }

  public SWIGTYPE_p_std__vectorT_int32_t_t getActiveAudioCodecList(String accountID) {
    return new SWIGTYPE_p_std__vectorT_int32_t_t(SFLPhoneserviceJNI.ConfigurationManagerJNI_getActiveAudioCodecList(swigCPtr, this, accountID), true);
  }

  public void setActiveAudioCodecList(StringVect list, String accountID) {
    SFLPhoneserviceJNI.ConfigurationManagerJNI_setActiveAudioCodecList(swigCPtr, this, StringVect.getCPtr(list), list, accountID);
  }

  public StringVect getAudioPluginList() {
    return new StringVect(SFLPhoneserviceJNI.ConfigurationManagerJNI_getAudioPluginList(swigCPtr, this), true);
  }

  public void setAudioPlugin(String audioPlugin) {
    SFLPhoneserviceJNI.ConfigurationManagerJNI_setAudioPlugin(swigCPtr, this, audioPlugin);
  }

  public StringVect getAudioOutputDeviceList() {
    return new StringVect(SFLPhoneserviceJNI.ConfigurationManagerJNI_getAudioOutputDeviceList(swigCPtr, this), true);
  }

  public StringVect getAudioInputDeviceList() {
    return new StringVect(SFLPhoneserviceJNI.ConfigurationManagerJNI_getAudioInputDeviceList(swigCPtr, this), true);
  }

  public void setAudioOutputDevice(SWIGTYPE_p_int32_t index) {
    SFLPhoneserviceJNI.ConfigurationManagerJNI_setAudioOutputDevice(swigCPtr, this, SWIGTYPE_p_int32_t.getCPtr(index));
  }

  public void setAudioInputDevice(SWIGTYPE_p_int32_t index) {
    SFLPhoneserviceJNI.ConfigurationManagerJNI_setAudioInputDevice(swigCPtr, this, SWIGTYPE_p_int32_t.getCPtr(index));
  }

  public void setAudioRingtoneDevice(SWIGTYPE_p_int32_t index) {
    SFLPhoneserviceJNI.ConfigurationManagerJNI_setAudioRingtoneDevice(swigCPtr, this, SWIGTYPE_p_int32_t.getCPtr(index));
  }

  public StringVect getCurrentAudioDevicesIndex() {
    return new StringVect(SFLPhoneserviceJNI.ConfigurationManagerJNI_getCurrentAudioDevicesIndex(swigCPtr, this), true);
  }

  public SWIGTYPE_p_int32_t getAudioDeviceIndex(String name) {
    return new SWIGTYPE_p_int32_t(SFLPhoneserviceJNI.ConfigurationManagerJNI_getAudioDeviceIndex(swigCPtr, this, name), true);
  }

  public String getCurrentAudioOutputPlugin() {
    return SFLPhoneserviceJNI.ConfigurationManagerJNI_getCurrentAudioOutputPlugin(swigCPtr, this);
  }

  public String getNoiseSuppressState() {
    return SFLPhoneserviceJNI.ConfigurationManagerJNI_getNoiseSuppressState(swigCPtr, this);
  }

  public void setNoiseSuppressState(String state) {
    SFLPhoneserviceJNI.ConfigurationManagerJNI_setNoiseSuppressState(swigCPtr, this, state);
  }

  public String getEchoCancelState() {
    return SFLPhoneserviceJNI.ConfigurationManagerJNI_getEchoCancelState(swigCPtr, this);
  }

  public StringMap getRingtoneList() {
    return new StringMap(SFLPhoneserviceJNI.ConfigurationManagerJNI_getRingtoneList(swigCPtr, this), true);
  }

  public void setEchoCancelState(String state) {
    SFLPhoneserviceJNI.ConfigurationManagerJNI_setEchoCancelState(swigCPtr, this, state);
  }

  public int getEchoCancelTailLength() {
    return SFLPhoneserviceJNI.ConfigurationManagerJNI_getEchoCancelTailLength(swigCPtr, this);
  }

  public void setEchoCancelTailLength(SWIGTYPE_p_int32_t length) {
    SFLPhoneserviceJNI.ConfigurationManagerJNI_setEchoCancelTailLength(swigCPtr, this, SWIGTYPE_p_int32_t.getCPtr(length));
  }

  public int getEchoCancelDelay() {
    return SFLPhoneserviceJNI.ConfigurationManagerJNI_getEchoCancelDelay(swigCPtr, this);
  }

  public void setEchoCancelDelay(SWIGTYPE_p_int32_t delay) {
    SFLPhoneserviceJNI.ConfigurationManagerJNI_setEchoCancelDelay(swigCPtr, this, SWIGTYPE_p_int32_t.getCPtr(delay));
  }

  public SWIGTYPE_p_int32_t isIax2Enabled() {
    return new SWIGTYPE_p_int32_t(SFLPhoneserviceJNI.ConfigurationManagerJNI_isIax2Enabled(swigCPtr, this), true);
  }

  public String getRecordPath() {
    return SFLPhoneserviceJNI.ConfigurationManagerJNI_getRecordPath(swigCPtr, this);
  }

  public void setRecordPath(String recPath) {
    SFLPhoneserviceJNI.ConfigurationManagerJNI_setRecordPath(swigCPtr, this, recPath);
  }

  public boolean getIsAlwaysRecording() {
    return SFLPhoneserviceJNI.ConfigurationManagerJNI_getIsAlwaysRecording(swigCPtr, this);
  }

  public void setIsAlwaysRecording(boolean rec) {
    SFLPhoneserviceJNI.ConfigurationManagerJNI_setIsAlwaysRecording(swigCPtr, this, rec);
  }

  public SWIGTYPE_p_int32_t getHistoryLimit() {
    return new SWIGTYPE_p_int32_t(SFLPhoneserviceJNI.ConfigurationManagerJNI_getHistoryLimit(swigCPtr, this), true);
  }

  public void clearHistory() {
    SFLPhoneserviceJNI.ConfigurationManagerJNI_clearHistory(swigCPtr, this);
  }

  public void setHistoryLimit(SWIGTYPE_p_int32_t days) {
    SFLPhoneserviceJNI.ConfigurationManagerJNI_setHistoryLimit(swigCPtr, this, SWIGTYPE_p_int32_t.getCPtr(days));
  }

  public void setAudioManager(String api) {
    SFLPhoneserviceJNI.ConfigurationManagerJNI_setAudioManager(swigCPtr, this, api);
  }

  public String getAudioManager() {
    return SFLPhoneserviceJNI.ConfigurationManagerJNI_getAudioManager(swigCPtr, this);
  }

  public StringMap getHookSettings() {
    return new StringMap(SFLPhoneserviceJNI.ConfigurationManagerJNI_getHookSettings(swigCPtr, this), true);
  }

  public void setHookSettings(StringMap settings) {
    SFLPhoneserviceJNI.ConfigurationManagerJNI_setHookSettings(swigCPtr, this, StringMap.getCPtr(settings), settings);
  }

  public void setAccountsOrder(String order) {
    SFLPhoneserviceJNI.ConfigurationManagerJNI_setAccountsOrder(swigCPtr, this, order);
  }

  public String getAddrFromInterfaceName(String arg0) {
    return SFLPhoneserviceJNI.ConfigurationManagerJNI_getAddrFromInterfaceName(swigCPtr, this, arg0);
  }

  public StringVect getAllIpInterface() {
    return new StringVect(SFLPhoneserviceJNI.ConfigurationManagerJNI_getAllIpInterface(swigCPtr, this), true);
  }

  public StringVect getAllIpInterfaceByName() {
    return new StringVect(SFLPhoneserviceJNI.ConfigurationManagerJNI_getAllIpInterfaceByName(swigCPtr, this), true);
  }

  public StringMap getShortcuts() {
    return new StringMap(SFLPhoneserviceJNI.ConfigurationManagerJNI_getShortcuts(swigCPtr, this), true);
  }

  public void setShortcuts(StringMap shortcutsMap) {
    SFLPhoneserviceJNI.ConfigurationManagerJNI_setShortcuts(swigCPtr, this, StringMap.getCPtr(shortcutsMap), shortcutsMap);
  }

  public SWIGTYPE_p_std__vectorT_std__mapT_std__string_std__string_t_t getCredentials(String accountID) {
    return new SWIGTYPE_p_std__vectorT_std__mapT_std__string_std__string_t_t(SFLPhoneserviceJNI.ConfigurationManagerJNI_getCredentials(swigCPtr, this, accountID), true);
  }

  public void setCredentials(String accountID, SWIGTYPE_p_std__vectorT_std__mapT_std__string_std__string_t_t details) {
    SFLPhoneserviceJNI.ConfigurationManagerJNI_setCredentials(swigCPtr, this, accountID, SWIGTYPE_p_std__vectorT_std__mapT_std__string_std__string_t_t.getCPtr(details));
  }

  public ConfigurationManagerJNI() {
    this(SFLPhoneserviceJNI.new_ConfigurationManagerJNI(), true);
  }

}
