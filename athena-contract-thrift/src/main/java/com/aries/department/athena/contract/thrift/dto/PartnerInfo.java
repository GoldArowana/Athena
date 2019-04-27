/**
 * Autogenerated by Thrift Compiler (0.12.0)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package com.aries.department.athena.contract.thrift.dto;

@SuppressWarnings({"cast", "rawtypes", "serial", "unchecked", "unused"})
@javax.annotation.Generated(value = "Autogenerated by Thrift Compiler (0.12.0)", date = "2019-04-27")
public class PartnerInfo implements org.apache.thrift.TBase<PartnerInfo, PartnerInfo._Fields>, java.io.Serializable, Cloneable, Comparable<PartnerInfo> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("PartnerInfo");

  private static final org.apache.thrift.protocol.TField ID_FIELD_DESC = new org.apache.thrift.protocol.TField("id", org.apache.thrift.protocol.TType.I32, (short)1);
  private static final org.apache.thrift.protocol.TField COMPANY_ID_FIELD_DESC = new org.apache.thrift.protocol.TField("companyId", org.apache.thrift.protocol.TType.I32, (short)2);
  private static final org.apache.thrift.protocol.TField COMPANY_NAME_FIELD_DESC = new org.apache.thrift.protocol.TField("companyName", org.apache.thrift.protocol.TType.STRING, (short)3);
  private static final org.apache.thrift.protocol.TField PASSWORD_FIELD_DESC = new org.apache.thrift.protocol.TField("password", org.apache.thrift.protocol.TType.STRING, (short)4);
  private static final org.apache.thrift.protocol.TField KEYWORD_FIELD_DESC = new org.apache.thrift.protocol.TField("keyword", org.apache.thrift.protocol.TType.STRING, (short)5);
  private static final org.apache.thrift.protocol.TField INSERT_TIME_FIELD_DESC = new org.apache.thrift.protocol.TField("insertTime", org.apache.thrift.protocol.TType.STRING, (short)6);
  private static final org.apache.thrift.protocol.TField UPDATE_TIME_FIELD_DESC = new org.apache.thrift.protocol.TField("updateTime", org.apache.thrift.protocol.TType.STRING, (short)7);

  private static final org.apache.thrift.scheme.SchemeFactory STANDARD_SCHEME_FACTORY = new PartnerInfoStandardSchemeFactory();
  private static final org.apache.thrift.scheme.SchemeFactory TUPLE_SCHEME_FACTORY = new PartnerInfoTupleSchemeFactory();

  public int id; // required
  public int companyId; // required
  public @org.apache.thrift.annotation.Nullable java.lang.String companyName; // required
  public @org.apache.thrift.annotation.Nullable java.lang.String password; // required
  public @org.apache.thrift.annotation.Nullable java.lang.String keyword; // required
  public @org.apache.thrift.annotation.Nullable java.lang.String insertTime; // required
  public @org.apache.thrift.annotation.Nullable java.lang.String updateTime; // required

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    ID((short)1, "id"),
    COMPANY_ID((short)2, "companyId"),
    COMPANY_NAME((short)3, "companyName"),
    PASSWORD((short)4, "password"),
    KEYWORD((short)5, "keyword"),
    INSERT_TIME((short)6, "insertTime"),
    UPDATE_TIME((short)7, "updateTime");

    private static final java.util.Map<java.lang.String, _Fields> byName = new java.util.HashMap<java.lang.String, _Fields>();

    static {
      for (_Fields field : java.util.EnumSet.allOf(_Fields.class)) {
        byName.put(field.getFieldName(), field);
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, or null if its not found.
     */
    @org.apache.thrift.annotation.Nullable
    public static _Fields findByThriftId(int fieldId) {
      switch(fieldId) {
        case 1: // ID
          return ID;
        case 2: // COMPANY_ID
          return COMPANY_ID;
        case 3: // COMPANY_NAME
          return COMPANY_NAME;
        case 4: // PASSWORD
          return PASSWORD;
        case 5: // KEYWORD
          return KEYWORD;
        case 6: // INSERT_TIME
          return INSERT_TIME;
        case 7: // UPDATE_TIME
          return UPDATE_TIME;
        default:
          return null;
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, throwing an exception
     * if it is not found.
     */
    public static _Fields findByThriftIdOrThrow(int fieldId) {
      _Fields fields = findByThriftId(fieldId);
      if (fields == null) throw new java.lang.IllegalArgumentException("Field " + fieldId + " doesn't exist!");
      return fields;
    }

    /**
     * Find the _Fields constant that matches name, or null if its not found.
     */
    @org.apache.thrift.annotation.Nullable
    public static _Fields findByName(java.lang.String name) {
      return byName.get(name);
    }

    private final short _thriftId;
    private final java.lang.String _fieldName;

    _Fields(short thriftId, java.lang.String fieldName) {
      _thriftId = thriftId;
      _fieldName = fieldName;
    }

    public short getThriftFieldId() {
      return _thriftId;
    }

    public java.lang.String getFieldName() {
      return _fieldName;
    }
  }

  // isset id assignments
  private static final int __ID_ISSET_ID = 0;
  private static final int __COMPANYID_ISSET_ID = 1;
  private byte __isset_bitfield = 0;
  public static final java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new java.util.EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.ID, new org.apache.thrift.meta_data.FieldMetaData("id", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
    tmpMap.put(_Fields.COMPANY_ID, new org.apache.thrift.meta_data.FieldMetaData("companyId", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
    tmpMap.put(_Fields.COMPANY_NAME, new org.apache.thrift.meta_data.FieldMetaData("companyName", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.PASSWORD, new org.apache.thrift.meta_data.FieldMetaData("password", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.KEYWORD, new org.apache.thrift.meta_data.FieldMetaData("keyword", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.INSERT_TIME, new org.apache.thrift.meta_data.FieldMetaData("insertTime", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.UPDATE_TIME, new org.apache.thrift.meta_data.FieldMetaData("updateTime", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    metaDataMap = java.util.Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(PartnerInfo.class, metaDataMap);
  }

  public PartnerInfo() {
  }

  public PartnerInfo(
    int id,
    int companyId,
    java.lang.String companyName,
    java.lang.String password,
    java.lang.String keyword,
    java.lang.String insertTime,
    java.lang.String updateTime)
  {
    this();
    this.id = id;
    setIdIsSet(true);
    this.companyId = companyId;
    setCompanyIdIsSet(true);
    this.companyName = companyName;
    this.password = password;
    this.keyword = keyword;
    this.insertTime = insertTime;
    this.updateTime = updateTime;
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public PartnerInfo(PartnerInfo other) {
    __isset_bitfield = other.__isset_bitfield;
    this.id = other.id;
    this.companyId = other.companyId;
    if (other.isSetCompanyName()) {
      this.companyName = other.companyName;
    }
    if (other.isSetPassword()) {
      this.password = other.password;
    }
    if (other.isSetKeyword()) {
      this.keyword = other.keyword;
    }
    if (other.isSetInsertTime()) {
      this.insertTime = other.insertTime;
    }
    if (other.isSetUpdateTime()) {
      this.updateTime = other.updateTime;
    }
  }

  public PartnerInfo deepCopy() {
    return new PartnerInfo(this);
  }

  @Override
  public void clear() {
    setIdIsSet(false);
    this.id = 0;
    setCompanyIdIsSet(false);
    this.companyId = 0;
    this.companyName = null;
    this.password = null;
    this.keyword = null;
    this.insertTime = null;
    this.updateTime = null;
  }

  public int getId() {
    return this.id;
  }

  public PartnerInfo setId(int id) {
    this.id = id;
    setIdIsSet(true);
    return this;
  }

  public void unsetId() {
    __isset_bitfield = org.apache.thrift.EncodingUtils.clearBit(__isset_bitfield, __ID_ISSET_ID);
  }

  /** Returns true if field id is set (has been assigned a value) and false otherwise */
  public boolean isSetId() {
    return org.apache.thrift.EncodingUtils.testBit(__isset_bitfield, __ID_ISSET_ID);
  }

  public void setIdIsSet(boolean value) {
    __isset_bitfield = org.apache.thrift.EncodingUtils.setBit(__isset_bitfield, __ID_ISSET_ID, value);
  }

  public int getCompanyId() {
    return this.companyId;
  }

  public PartnerInfo setCompanyId(int companyId) {
    this.companyId = companyId;
    setCompanyIdIsSet(true);
    return this;
  }

  public void unsetCompanyId() {
    __isset_bitfield = org.apache.thrift.EncodingUtils.clearBit(__isset_bitfield, __COMPANYID_ISSET_ID);
  }

  /** Returns true if field companyId is set (has been assigned a value) and false otherwise */
  public boolean isSetCompanyId() {
    return org.apache.thrift.EncodingUtils.testBit(__isset_bitfield, __COMPANYID_ISSET_ID);
  }

  public void setCompanyIdIsSet(boolean value) {
    __isset_bitfield = org.apache.thrift.EncodingUtils.setBit(__isset_bitfield, __COMPANYID_ISSET_ID, value);
  }

  @org.apache.thrift.annotation.Nullable
  public java.lang.String getCompanyName() {
    return this.companyName;
  }

  public PartnerInfo setCompanyName(@org.apache.thrift.annotation.Nullable java.lang.String companyName) {
    this.companyName = companyName;
    return this;
  }

  public void unsetCompanyName() {
    this.companyName = null;
  }

  /** Returns true if field companyName is set (has been assigned a value) and false otherwise */
  public boolean isSetCompanyName() {
    return this.companyName != null;
  }

  public void setCompanyNameIsSet(boolean value) {
    if (!value) {
      this.companyName = null;
    }
  }

  @org.apache.thrift.annotation.Nullable
  public java.lang.String getPassword() {
    return this.password;
  }

  public PartnerInfo setPassword(@org.apache.thrift.annotation.Nullable java.lang.String password) {
    this.password = password;
    return this;
  }

  public void unsetPassword() {
    this.password = null;
  }

  /** Returns true if field password is set (has been assigned a value) and false otherwise */
  public boolean isSetPassword() {
    return this.password != null;
  }

  public void setPasswordIsSet(boolean value) {
    if (!value) {
      this.password = null;
    }
  }

  @org.apache.thrift.annotation.Nullable
  public java.lang.String getKeyword() {
    return this.keyword;
  }

  public PartnerInfo setKeyword(@org.apache.thrift.annotation.Nullable java.lang.String keyword) {
    this.keyword = keyword;
    return this;
  }

  public void unsetKeyword() {
    this.keyword = null;
  }

  /** Returns true if field keyword is set (has been assigned a value) and false otherwise */
  public boolean isSetKeyword() {
    return this.keyword != null;
  }

  public void setKeywordIsSet(boolean value) {
    if (!value) {
      this.keyword = null;
    }
  }

  @org.apache.thrift.annotation.Nullable
  public java.lang.String getInsertTime() {
    return this.insertTime;
  }

  public PartnerInfo setInsertTime(@org.apache.thrift.annotation.Nullable java.lang.String insertTime) {
    this.insertTime = insertTime;
    return this;
  }

  public void unsetInsertTime() {
    this.insertTime = null;
  }

  /** Returns true if field insertTime is set (has been assigned a value) and false otherwise */
  public boolean isSetInsertTime() {
    return this.insertTime != null;
  }

  public void setInsertTimeIsSet(boolean value) {
    if (!value) {
      this.insertTime = null;
    }
  }

  @org.apache.thrift.annotation.Nullable
  public java.lang.String getUpdateTime() {
    return this.updateTime;
  }

  public PartnerInfo setUpdateTime(@org.apache.thrift.annotation.Nullable java.lang.String updateTime) {
    this.updateTime = updateTime;
    return this;
  }

  public void unsetUpdateTime() {
    this.updateTime = null;
  }

  /** Returns true if field updateTime is set (has been assigned a value) and false otherwise */
  public boolean isSetUpdateTime() {
    return this.updateTime != null;
  }

  public void setUpdateTimeIsSet(boolean value) {
    if (!value) {
      this.updateTime = null;
    }
  }

  public void setFieldValue(_Fields field, @org.apache.thrift.annotation.Nullable java.lang.Object value) {
    switch (field) {
    case ID:
      if (value == null) {
        unsetId();
      } else {
        setId((java.lang.Integer)value);
      }
      break;

    case COMPANY_ID:
      if (value == null) {
        unsetCompanyId();
      } else {
        setCompanyId((java.lang.Integer)value);
      }
      break;

    case COMPANY_NAME:
      if (value == null) {
        unsetCompanyName();
      } else {
        setCompanyName((java.lang.String)value);
      }
      break;

    case PASSWORD:
      if (value == null) {
        unsetPassword();
      } else {
        setPassword((java.lang.String)value);
      }
      break;

    case KEYWORD:
      if (value == null) {
        unsetKeyword();
      } else {
        setKeyword((java.lang.String)value);
      }
      break;

    case INSERT_TIME:
      if (value == null) {
        unsetInsertTime();
      } else {
        setInsertTime((java.lang.String)value);
      }
      break;

    case UPDATE_TIME:
      if (value == null) {
        unsetUpdateTime();
      } else {
        setUpdateTime((java.lang.String)value);
      }
      break;

    }
  }

  @org.apache.thrift.annotation.Nullable
  public java.lang.Object getFieldValue(_Fields field) {
    switch (field) {
    case ID:
      return getId();

    case COMPANY_ID:
      return getCompanyId();

    case COMPANY_NAME:
      return getCompanyName();

    case PASSWORD:
      return getPassword();

    case KEYWORD:
      return getKeyword();

    case INSERT_TIME:
      return getInsertTime();

    case UPDATE_TIME:
      return getUpdateTime();

    }
    throw new java.lang.IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new java.lang.IllegalArgumentException();
    }

    switch (field) {
    case ID:
      return isSetId();
    case COMPANY_ID:
      return isSetCompanyId();
    case COMPANY_NAME:
      return isSetCompanyName();
    case PASSWORD:
      return isSetPassword();
    case KEYWORD:
      return isSetKeyword();
    case INSERT_TIME:
      return isSetInsertTime();
    case UPDATE_TIME:
      return isSetUpdateTime();
    }
    throw new java.lang.IllegalStateException();
  }

  @Override
  public boolean equals(java.lang.Object that) {
    if (that == null)
      return false;
    if (that instanceof PartnerInfo)
      return this.equals((PartnerInfo)that);
    return false;
  }

  public boolean equals(PartnerInfo that) {
    if (that == null)
      return false;
    if (this == that)
      return true;

    boolean this_present_id = true;
    boolean that_present_id = true;
    if (this_present_id || that_present_id) {
      if (!(this_present_id && that_present_id))
        return false;
      if (this.id != that.id)
        return false;
    }

    boolean this_present_companyId = true;
    boolean that_present_companyId = true;
    if (this_present_companyId || that_present_companyId) {
      if (!(this_present_companyId && that_present_companyId))
        return false;
      if (this.companyId != that.companyId)
        return false;
    }

    boolean this_present_companyName = true && this.isSetCompanyName();
    boolean that_present_companyName = true && that.isSetCompanyName();
    if (this_present_companyName || that_present_companyName) {
      if (!(this_present_companyName && that_present_companyName))
        return false;
      if (!this.companyName.equals(that.companyName))
        return false;
    }

    boolean this_present_password = true && this.isSetPassword();
    boolean that_present_password = true && that.isSetPassword();
    if (this_present_password || that_present_password) {
      if (!(this_present_password && that_present_password))
        return false;
      if (!this.password.equals(that.password))
        return false;
    }

    boolean this_present_keyword = true && this.isSetKeyword();
    boolean that_present_keyword = true && that.isSetKeyword();
    if (this_present_keyword || that_present_keyword) {
      if (!(this_present_keyword && that_present_keyword))
        return false;
      if (!this.keyword.equals(that.keyword))
        return false;
    }

    boolean this_present_insertTime = true && this.isSetInsertTime();
    boolean that_present_insertTime = true && that.isSetInsertTime();
    if (this_present_insertTime || that_present_insertTime) {
      if (!(this_present_insertTime && that_present_insertTime))
        return false;
      if (!this.insertTime.equals(that.insertTime))
        return false;
    }

    boolean this_present_updateTime = true && this.isSetUpdateTime();
    boolean that_present_updateTime = true && that.isSetUpdateTime();
    if (this_present_updateTime || that_present_updateTime) {
      if (!(this_present_updateTime && that_present_updateTime))
        return false;
      if (!this.updateTime.equals(that.updateTime))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    int hashCode = 1;

    hashCode = hashCode * 8191 + id;

    hashCode = hashCode * 8191 + companyId;

    hashCode = hashCode * 8191 + ((isSetCompanyName()) ? 131071 : 524287);
    if (isSetCompanyName())
      hashCode = hashCode * 8191 + companyName.hashCode();

    hashCode = hashCode * 8191 + ((isSetPassword()) ? 131071 : 524287);
    if (isSetPassword())
      hashCode = hashCode * 8191 + password.hashCode();

    hashCode = hashCode * 8191 + ((isSetKeyword()) ? 131071 : 524287);
    if (isSetKeyword())
      hashCode = hashCode * 8191 + keyword.hashCode();

    hashCode = hashCode * 8191 + ((isSetInsertTime()) ? 131071 : 524287);
    if (isSetInsertTime())
      hashCode = hashCode * 8191 + insertTime.hashCode();

    hashCode = hashCode * 8191 + ((isSetUpdateTime()) ? 131071 : 524287);
    if (isSetUpdateTime())
      hashCode = hashCode * 8191 + updateTime.hashCode();

    return hashCode;
  }

  @Override
  public int compareTo(PartnerInfo other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = java.lang.Boolean.valueOf(isSetId()).compareTo(other.isSetId());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetId()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.id, other.id);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.valueOf(isSetCompanyId()).compareTo(other.isSetCompanyId());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetCompanyId()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.companyId, other.companyId);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.valueOf(isSetCompanyName()).compareTo(other.isSetCompanyName());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetCompanyName()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.companyName, other.companyName);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.valueOf(isSetPassword()).compareTo(other.isSetPassword());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetPassword()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.password, other.password);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.valueOf(isSetKeyword()).compareTo(other.isSetKeyword());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetKeyword()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.keyword, other.keyword);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.valueOf(isSetInsertTime()).compareTo(other.isSetInsertTime());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetInsertTime()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.insertTime, other.insertTime);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.valueOf(isSetUpdateTime()).compareTo(other.isSetUpdateTime());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetUpdateTime()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.updateTime, other.updateTime);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    return 0;
  }

  @org.apache.thrift.annotation.Nullable
  public _Fields fieldForId(int fieldId) {
    return _Fields.findByThriftId(fieldId);
  }

  public void read(org.apache.thrift.protocol.TProtocol iprot) throws org.apache.thrift.TException {
    scheme(iprot).read(iprot, this);
  }

  public void write(org.apache.thrift.protocol.TProtocol oprot) throws org.apache.thrift.TException {
    scheme(oprot).write(oprot, this);
  }

  @Override
  public java.lang.String toString() {
    java.lang.StringBuilder sb = new java.lang.StringBuilder("PartnerInfo(");
    boolean first = true;

    sb.append("id:");
    sb.append(this.id);
    first = false;
    if (!first) sb.append(", ");
    sb.append("companyId:");
    sb.append(this.companyId);
    first = false;
    if (!first) sb.append(", ");
    sb.append("companyName:");
    if (this.companyName == null) {
      sb.append("null");
    } else {
      sb.append(this.companyName);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("password:");
    if (this.password == null) {
      sb.append("null");
    } else {
      sb.append(this.password);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("keyword:");
    if (this.keyword == null) {
      sb.append("null");
    } else {
      sb.append(this.keyword);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("insertTime:");
    if (this.insertTime == null) {
      sb.append("null");
    } else {
      sb.append(this.insertTime);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("updateTime:");
    if (this.updateTime == null) {
      sb.append("null");
    } else {
      sb.append(this.updateTime);
    }
    first = false;
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
    // check for sub-struct validity
  }

  private void writeObject(java.io.ObjectOutputStream out) throws java.io.IOException {
    try {
      write(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(out)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private void readObject(java.io.ObjectInputStream in) throws java.io.IOException, java.lang.ClassNotFoundException {
    try {
      // it doesn't seem like you should have to do this, but java serialization is wacky, and doesn't call the default constructor.
      __isset_bitfield = 0;
      read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private static class PartnerInfoStandardSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    public PartnerInfoStandardScheme getScheme() {
      return new PartnerInfoStandardScheme();
    }
  }

  private static class PartnerInfoStandardScheme extends org.apache.thrift.scheme.StandardScheme<PartnerInfo> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, PartnerInfo struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // ID
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.id = iprot.readI32();
              struct.setIdIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // COMPANY_ID
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.companyId = iprot.readI32();
              struct.setCompanyIdIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 3: // COMPANY_NAME
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.companyName = iprot.readString();
              struct.setCompanyNameIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 4: // PASSWORD
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.password = iprot.readString();
              struct.setPasswordIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 5: // KEYWORD
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.keyword = iprot.readString();
              struct.setKeywordIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 6: // INSERT_TIME
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.insertTime = iprot.readString();
              struct.setInsertTimeIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 7: // UPDATE_TIME
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.updateTime = iprot.readString();
              struct.setUpdateTimeIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          default:
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
        }
        iprot.readFieldEnd();
      }
      iprot.readStructEnd();

      // check for required fields of primitive type, which can't be checked in the validate method
      struct.validate();
    }

    public void write(org.apache.thrift.protocol.TProtocol oprot, PartnerInfo struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      oprot.writeFieldBegin(ID_FIELD_DESC);
      oprot.writeI32(struct.id);
      oprot.writeFieldEnd();
      oprot.writeFieldBegin(COMPANY_ID_FIELD_DESC);
      oprot.writeI32(struct.companyId);
      oprot.writeFieldEnd();
      if (struct.companyName != null) {
        oprot.writeFieldBegin(COMPANY_NAME_FIELD_DESC);
        oprot.writeString(struct.companyName);
        oprot.writeFieldEnd();
      }
      if (struct.password != null) {
        oprot.writeFieldBegin(PASSWORD_FIELD_DESC);
        oprot.writeString(struct.password);
        oprot.writeFieldEnd();
      }
      if (struct.keyword != null) {
        oprot.writeFieldBegin(KEYWORD_FIELD_DESC);
        oprot.writeString(struct.keyword);
        oprot.writeFieldEnd();
      }
      if (struct.insertTime != null) {
        oprot.writeFieldBegin(INSERT_TIME_FIELD_DESC);
        oprot.writeString(struct.insertTime);
        oprot.writeFieldEnd();
      }
      if (struct.updateTime != null) {
        oprot.writeFieldBegin(UPDATE_TIME_FIELD_DESC);
        oprot.writeString(struct.updateTime);
        oprot.writeFieldEnd();
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class PartnerInfoTupleSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    public PartnerInfoTupleScheme getScheme() {
      return new PartnerInfoTupleScheme();
    }
  }

  private static class PartnerInfoTupleScheme extends org.apache.thrift.scheme.TupleScheme<PartnerInfo> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, PartnerInfo struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol oprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      java.util.BitSet optionals = new java.util.BitSet();
      if (struct.isSetId()) {
        optionals.set(0);
      }
      if (struct.isSetCompanyId()) {
        optionals.set(1);
      }
      if (struct.isSetCompanyName()) {
        optionals.set(2);
      }
      if (struct.isSetPassword()) {
        optionals.set(3);
      }
      if (struct.isSetKeyword()) {
        optionals.set(4);
      }
      if (struct.isSetInsertTime()) {
        optionals.set(5);
      }
      if (struct.isSetUpdateTime()) {
        optionals.set(6);
      }
      oprot.writeBitSet(optionals, 7);
      if (struct.isSetId()) {
        oprot.writeI32(struct.id);
      }
      if (struct.isSetCompanyId()) {
        oprot.writeI32(struct.companyId);
      }
      if (struct.isSetCompanyName()) {
        oprot.writeString(struct.companyName);
      }
      if (struct.isSetPassword()) {
        oprot.writeString(struct.password);
      }
      if (struct.isSetKeyword()) {
        oprot.writeString(struct.keyword);
      }
      if (struct.isSetInsertTime()) {
        oprot.writeString(struct.insertTime);
      }
      if (struct.isSetUpdateTime()) {
        oprot.writeString(struct.updateTime);
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, PartnerInfo struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol iprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      java.util.BitSet incoming = iprot.readBitSet(7);
      if (incoming.get(0)) {
        struct.id = iprot.readI32();
        struct.setIdIsSet(true);
      }
      if (incoming.get(1)) {
        struct.companyId = iprot.readI32();
        struct.setCompanyIdIsSet(true);
      }
      if (incoming.get(2)) {
        struct.companyName = iprot.readString();
        struct.setCompanyNameIsSet(true);
      }
      if (incoming.get(3)) {
        struct.password = iprot.readString();
        struct.setPasswordIsSet(true);
      }
      if (incoming.get(4)) {
        struct.keyword = iprot.readString();
        struct.setKeywordIsSet(true);
      }
      if (incoming.get(5)) {
        struct.insertTime = iprot.readString();
        struct.setInsertTimeIsSet(true);
      }
      if (incoming.get(6)) {
        struct.updateTime = iprot.readString();
        struct.setUpdateTimeIsSet(true);
      }
    }
  }

  private static <S extends org.apache.thrift.scheme.IScheme> S scheme(org.apache.thrift.protocol.TProtocol proto) {
    return (org.apache.thrift.scheme.StandardScheme.class.equals(proto.getScheme()) ? STANDARD_SCHEME_FACTORY : TUPLE_SCHEME_FACTORY).getScheme();
  }
}

