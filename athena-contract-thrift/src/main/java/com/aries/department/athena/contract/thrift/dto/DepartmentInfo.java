/**
 * Autogenerated by Thrift Compiler (0.12.0)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package com.aries.department.athena.contract.thrift.dto;

@SuppressWarnings({"cast", "rawtypes", "serial", "unchecked", "unused"})
@javax.annotation.Generated(value = "Autogenerated by Thrift Compiler (0.12.0)", date = "2019-04-26")
public class DepartmentInfo implements org.apache.thrift.TBase<DepartmentInfo, DepartmentInfo._Fields>, java.io.Serializable, Cloneable, Comparable<DepartmentInfo> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("DepartmentInfo");

  private static final org.apache.thrift.protocol.TField ID_FIELD_DESC = new org.apache.thrift.protocol.TField("id", org.apache.thrift.protocol.TType.I32, (short)1);
  private static final org.apache.thrift.protocol.TField DEPARTMENT_NAME_FIELD_DESC = new org.apache.thrift.protocol.TField("departmentName", org.apache.thrift.protocol.TType.STRING, (short)2);
  private static final org.apache.thrift.protocol.TField LEADER_ID_FIELD_DESC = new org.apache.thrift.protocol.TField("leaderId", org.apache.thrift.protocol.TType.I32, (short)3);
  private static final org.apache.thrift.protocol.TField UP_ID_FIELD_DESC = new org.apache.thrift.protocol.TField("upId", org.apache.thrift.protocol.TType.I32, (short)4);

  private static final org.apache.thrift.scheme.SchemeFactory STANDARD_SCHEME_FACTORY = new DepartmentInfoStandardSchemeFactory();
  private static final org.apache.thrift.scheme.SchemeFactory TUPLE_SCHEME_FACTORY = new DepartmentInfoTupleSchemeFactory();

  public int id; // required
  public @org.apache.thrift.annotation.Nullable String departmentName; // required
  public int leaderId; // required
  public int upId; // required

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    ID((short)1, "id"),
    DEPARTMENT_NAME((short)2, "departmentName"),
    LEADER_ID((short)3, "leaderId"),
    UP_ID((short)4, "upId");

    private static final java.util.Map<String, _Fields> byName = new java.util.HashMap<String, _Fields>();

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
        case 2: // DEPARTMENT_NAME
          return DEPARTMENT_NAME;
        case 3: // LEADER_ID
          return LEADER_ID;
        case 4: // UP_ID
          return UP_ID;
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
      if (fields == null) throw new IllegalArgumentException("Field " + fieldId + " doesn't exist!");
      return fields;
    }

    /**
     * Find the _Fields constant that matches name, or null if its not found.
     */
    @org.apache.thrift.annotation.Nullable
    public static _Fields findByName(String name) {
      return byName.get(name);
    }

    private final short _thriftId;
    private final String _fieldName;

    _Fields(short thriftId, String fieldName) {
      _thriftId = thriftId;
      _fieldName = fieldName;
    }

    public short getThriftFieldId() {
      return _thriftId;
    }

    public String getFieldName() {
      return _fieldName;
    }
  }

  // isset id assignments
  private static final int __ID_ISSET_ID = 0;
  private static final int __LEADERID_ISSET_ID = 1;
  private static final int __UPID_ISSET_ID = 2;
  private byte __isset_bitfield = 0;
  public static final java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new java.util.EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.ID, new org.apache.thrift.meta_data.FieldMetaData("id", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
    tmpMap.put(_Fields.DEPARTMENT_NAME, new org.apache.thrift.meta_data.FieldMetaData("departmentName", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.LEADER_ID, new org.apache.thrift.meta_data.FieldMetaData("leaderId", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
    tmpMap.put(_Fields.UP_ID, new org.apache.thrift.meta_data.FieldMetaData("upId", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
    metaDataMap = java.util.Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(DepartmentInfo.class, metaDataMap);
  }

  public DepartmentInfo() {
  }

  public DepartmentInfo(
    int id,
    String departmentName,
    int leaderId,
    int upId)
  {
    this();
    this.id = id;
    setIdIsSet(true);
    this.departmentName = departmentName;
    this.leaderId = leaderId;
    setLeaderIdIsSet(true);
    this.upId = upId;
    setUpIdIsSet(true);
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public DepartmentInfo(DepartmentInfo other) {
    __isset_bitfield = other.__isset_bitfield;
    this.id = other.id;
    if (other.isSetDepartmentName()) {
      this.departmentName = other.departmentName;
    }
    this.leaderId = other.leaderId;
    this.upId = other.upId;
  }

  public DepartmentInfo deepCopy() {
    return new DepartmentInfo(this);
  }

  @Override
  public void clear() {
    setIdIsSet(false);
    this.id = 0;
    this.departmentName = null;
    setLeaderIdIsSet(false);
    this.leaderId = 0;
    setUpIdIsSet(false);
    this.upId = 0;
  }

  public int getId() {
    return this.id;
  }

  public DepartmentInfo setId(int id) {
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

  @org.apache.thrift.annotation.Nullable
  public String getDepartmentName() {
    return this.departmentName;
  }

  public DepartmentInfo setDepartmentName(@org.apache.thrift.annotation.Nullable String departmentName) {
    this.departmentName = departmentName;
    return this;
  }

  public void unsetDepartmentName() {
    this.departmentName = null;
  }

  /** Returns true if field departmentName is set (has been assigned a value) and false otherwise */
  public boolean isSetDepartmentName() {
    return this.departmentName != null;
  }

  public void setDepartmentNameIsSet(boolean value) {
    if (!value) {
      this.departmentName = null;
    }
  }

  public int getLeaderId() {
    return this.leaderId;
  }

  public DepartmentInfo setLeaderId(int leaderId) {
    this.leaderId = leaderId;
    setLeaderIdIsSet(true);
    return this;
  }

  public void unsetLeaderId() {
    __isset_bitfield = org.apache.thrift.EncodingUtils.clearBit(__isset_bitfield, __LEADERID_ISSET_ID);
  }

  /** Returns true if field leaderId is set (has been assigned a value) and false otherwise */
  public boolean isSetLeaderId() {
    return org.apache.thrift.EncodingUtils.testBit(__isset_bitfield, __LEADERID_ISSET_ID);
  }

  public void setLeaderIdIsSet(boolean value) {
    __isset_bitfield = org.apache.thrift.EncodingUtils.setBit(__isset_bitfield, __LEADERID_ISSET_ID, value);
  }

  public int getUpId() {
    return this.upId;
  }

  public DepartmentInfo setUpId(int upId) {
    this.upId = upId;
    setUpIdIsSet(true);
    return this;
  }

  public void unsetUpId() {
    __isset_bitfield = org.apache.thrift.EncodingUtils.clearBit(__isset_bitfield, __UPID_ISSET_ID);
  }

  /** Returns true if field upId is set (has been assigned a value) and false otherwise */
  public boolean isSetUpId() {
    return org.apache.thrift.EncodingUtils.testBit(__isset_bitfield, __UPID_ISSET_ID);
  }

  public void setUpIdIsSet(boolean value) {
    __isset_bitfield = org.apache.thrift.EncodingUtils.setBit(__isset_bitfield, __UPID_ISSET_ID, value);
  }

  public void setFieldValue(_Fields field, @org.apache.thrift.annotation.Nullable Object value) {
    switch (field) {
    case ID:
      if (value == null) {
        unsetId();
      } else {
        setId((Integer)value);
      }
      break;

    case DEPARTMENT_NAME:
      if (value == null) {
        unsetDepartmentName();
      } else {
        setDepartmentName((String)value);
      }
      break;

    case LEADER_ID:
      if (value == null) {
        unsetLeaderId();
      } else {
        setLeaderId((Integer)value);
      }
      break;

    case UP_ID:
      if (value == null) {
        unsetUpId();
      } else {
        setUpId((Integer)value);
      }
      break;

    }
  }

  @org.apache.thrift.annotation.Nullable
  public Object getFieldValue(_Fields field) {
    switch (field) {
    case ID:
      return getId();

    case DEPARTMENT_NAME:
      return getDepartmentName();

    case LEADER_ID:
      return getLeaderId();

    case UP_ID:
      return getUpId();

    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case ID:
      return isSetId();
    case DEPARTMENT_NAME:
      return isSetDepartmentName();
    case LEADER_ID:
      return isSetLeaderId();
    case UP_ID:
      return isSetUpId();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof DepartmentInfo)
      return this.equals((DepartmentInfo)that);
    return false;
  }

  public boolean equals(DepartmentInfo that) {
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

    boolean this_present_departmentName = true && this.isSetDepartmentName();
    boolean that_present_departmentName = true && that.isSetDepartmentName();
    if (this_present_departmentName || that_present_departmentName) {
      if (!(this_present_departmentName && that_present_departmentName))
        return false;
      if (!this.departmentName.equals(that.departmentName))
        return false;
    }

    boolean this_present_leaderId = true;
    boolean that_present_leaderId = true;
    if (this_present_leaderId || that_present_leaderId) {
      if (!(this_present_leaderId && that_present_leaderId))
        return false;
      if (this.leaderId != that.leaderId)
        return false;
    }

    boolean this_present_upId = true;
    boolean that_present_upId = true;
    if (this_present_upId || that_present_upId) {
      if (!(this_present_upId && that_present_upId))
        return false;
      if (this.upId != that.upId)
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    int hashCode = 1;

    hashCode = hashCode * 8191 + id;

    hashCode = hashCode * 8191 + ((isSetDepartmentName()) ? 131071 : 524287);
    if (isSetDepartmentName())
      hashCode = hashCode * 8191 + departmentName.hashCode();

    hashCode = hashCode * 8191 + leaderId;

    hashCode = hashCode * 8191 + upId;

    return hashCode;
  }

  @Override
  public int compareTo(DepartmentInfo other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = Boolean.valueOf(isSetId()).compareTo(other.isSetId());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetId()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.id, other.id);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetDepartmentName()).compareTo(other.isSetDepartmentName());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetDepartmentName()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.departmentName, other.departmentName);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetLeaderId()).compareTo(other.isSetLeaderId());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetLeaderId()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.leaderId, other.leaderId);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetUpId()).compareTo(other.isSetUpId());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetUpId()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.upId, other.upId);
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
  public String toString() {
    StringBuilder sb = new StringBuilder("DepartmentInfo(");
    boolean first = true;

    sb.append("id:");
    sb.append(this.id);
    first = false;
    if (!first) sb.append(", ");
    sb.append("departmentName:");
    if (this.departmentName == null) {
      sb.append("null");
    } else {
      sb.append(this.departmentName);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("leaderId:");
    sb.append(this.leaderId);
    first = false;
    if (!first) sb.append(", ");
    sb.append("upId:");
    sb.append(this.upId);
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

  private void readObject(java.io.ObjectInputStream in) throws java.io.IOException, ClassNotFoundException {
    try {
      // it doesn't seem like you should have to do this, but java serialization is wacky, and doesn't call the default constructor.
      __isset_bitfield = 0;
      read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private static class DepartmentInfoStandardSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    public DepartmentInfoStandardScheme getScheme() {
      return new DepartmentInfoStandardScheme();
    }
  }

  private static class DepartmentInfoStandardScheme extends org.apache.thrift.scheme.StandardScheme<DepartmentInfo> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, DepartmentInfo struct) throws org.apache.thrift.TException {
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
          case 2: // DEPARTMENT_NAME
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.departmentName = iprot.readString();
              struct.setDepartmentNameIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 3: // LEADER_ID
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.leaderId = iprot.readI32();
              struct.setLeaderIdIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 4: // UP_ID
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.upId = iprot.readI32();
              struct.setUpIdIsSet(true);
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

    public void write(org.apache.thrift.protocol.TProtocol oprot, DepartmentInfo struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      oprot.writeFieldBegin(ID_FIELD_DESC);
      oprot.writeI32(struct.id);
      oprot.writeFieldEnd();
      if (struct.departmentName != null) {
        oprot.writeFieldBegin(DEPARTMENT_NAME_FIELD_DESC);
        oprot.writeString(struct.departmentName);
        oprot.writeFieldEnd();
      }
      oprot.writeFieldBegin(LEADER_ID_FIELD_DESC);
      oprot.writeI32(struct.leaderId);
      oprot.writeFieldEnd();
      oprot.writeFieldBegin(UP_ID_FIELD_DESC);
      oprot.writeI32(struct.upId);
      oprot.writeFieldEnd();
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class DepartmentInfoTupleSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    public DepartmentInfoTupleScheme getScheme() {
      return new DepartmentInfoTupleScheme();
    }
  }

  private static class DepartmentInfoTupleScheme extends org.apache.thrift.scheme.TupleScheme<DepartmentInfo> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, DepartmentInfo struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol oprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      java.util.BitSet optionals = new java.util.BitSet();
      if (struct.isSetId()) {
        optionals.set(0);
      }
      if (struct.isSetDepartmentName()) {
        optionals.set(1);
      }
      if (struct.isSetLeaderId()) {
        optionals.set(2);
      }
      if (struct.isSetUpId()) {
        optionals.set(3);
      }
      oprot.writeBitSet(optionals, 4);
      if (struct.isSetId()) {
        oprot.writeI32(struct.id);
      }
      if (struct.isSetDepartmentName()) {
        oprot.writeString(struct.departmentName);
      }
      if (struct.isSetLeaderId()) {
        oprot.writeI32(struct.leaderId);
      }
      if (struct.isSetUpId()) {
        oprot.writeI32(struct.upId);
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, DepartmentInfo struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol iprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      java.util.BitSet incoming = iprot.readBitSet(4);
      if (incoming.get(0)) {
        struct.id = iprot.readI32();
        struct.setIdIsSet(true);
      }
      if (incoming.get(1)) {
        struct.departmentName = iprot.readString();
        struct.setDepartmentNameIsSet(true);
      }
      if (incoming.get(2)) {
        struct.leaderId = iprot.readI32();
        struct.setLeaderIdIsSet(true);
      }
      if (incoming.get(3)) {
        struct.upId = iprot.readI32();
        struct.setUpIdIsSet(true);
      }
    }
  }

  private static <S extends org.apache.thrift.scheme.IScheme> S scheme(org.apache.thrift.protocol.TProtocol proto) {
    return (org.apache.thrift.scheme.StandardScheme.class.equals(proto.getScheme()) ? STANDARD_SCHEME_FACTORY : TUPLE_SCHEME_FACTORY).getScheme();
  }
}
