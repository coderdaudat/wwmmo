// Code generated by Wire protocol buffer compiler, do not edit.
// Source file: star.proto at 8:1
package au.com.codeka.warworlds.common.proto;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireField;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.lang.Integer;
import java.lang.Long;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.StringBuilder;
import java.util.List;
import okio.ByteString;

/**
 *
 * Represents a "sector" of space, containing a number of stars and whatnot.
 */
public final class Sector extends Message<Sector, Sector.Builder> {
  public static final ProtoAdapter<Sector> ADAPTER = new ProtoAdapter_Sector();

  private static final long serialVersionUID = 0L;

  public static final Long DEFAULT_X = 0L;

  public static final Long DEFAULT_Y = 0L;

  public static final Integer DEFAULT_NUM_COLONIES = 0;

  /**
   * these are the (x,y) coordinates of the sector. (0,0) is the "centre" of the universe,
   * (1,1) is one sector up and to the right, and so on.
   */
  @WireField(
      tag = 1,
      adapter = "com.squareup.wire.ProtoAdapter#INT64"
  )
  public final Long x;

  @WireField(
      tag = 2,
      adapter = "com.squareup.wire.ProtoAdapter#INT64"
  )
  public final Long y;

  /**
   * number of colonies in this sector
   */
  @WireField(
      tag = 5,
      adapter = "com.squareup.wire.ProtoAdapter#INT32"
  )
  public final Integer num_colonies;

  /**
   * the collection of stars in this sector.
   */
  @WireField(
      tag = 3,
      adapter = "au.com.codeka.warworlds.common.proto.Star#ADAPTER",
      label = WireField.Label.REPEATED
  )
  public final List<Star> stars;

  public Sector(Long x, Long y, Integer num_colonies, List<Star> stars) {
    this(x, y, num_colonies, stars, ByteString.EMPTY);
  }

  public Sector(Long x, Long y, Integer num_colonies, List<Star> stars, ByteString unknownFields) {
    super(ADAPTER, unknownFields);
    this.x = x;
    this.y = y;
    this.num_colonies = num_colonies;
    this.stars = Internal.immutableCopyOf("stars", stars);
  }

  @Override
  public Builder newBuilder() {
    Builder builder = new Builder();
    builder.x = x;
    builder.y = y;
    builder.num_colonies = num_colonies;
    builder.stars = Internal.copyOf("stars", stars);
    builder.addUnknownFields(unknownFields());
    return builder;
  }

  @Override
  public boolean equals(Object other) {
    if (other == this) return true;
    if (!(other instanceof Sector)) return false;
    Sector o = (Sector) other;
    return Internal.equals(unknownFields(), o.unknownFields())
        && Internal.equals(x, o.x)
        && Internal.equals(y, o.y)
        && Internal.equals(num_colonies, o.num_colonies)
        && Internal.equals(stars, o.stars);
  }

  @Override
  public int hashCode() {
    int result = super.hashCode;
    if (result == 0) {
      result = unknownFields().hashCode();
      result = result * 37 + (x != null ? x.hashCode() : 0);
      result = result * 37 + (y != null ? y.hashCode() : 0);
      result = result * 37 + (num_colonies != null ? num_colonies.hashCode() : 0);
      result = result * 37 + (stars != null ? stars.hashCode() : 1);
      super.hashCode = result;
    }
    return result;
  }

  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();
    if (x != null) builder.append(", x=").append(x);
    if (y != null) builder.append(", y=").append(y);
    if (num_colonies != null) builder.append(", num_colonies=").append(num_colonies);
    if (stars != null) builder.append(", stars=").append(stars);
    return builder.replace(0, 2, "Sector{").append('}').toString();
  }

  public static final class Builder extends Message.Builder<Sector, Builder> {
    public Long x;

    public Long y;

    public Integer num_colonies;

    public List<Star> stars;

    public Builder() {
      stars = Internal.newMutableList();
    }

    /**
     * these are the (x,y) coordinates of the sector. (0,0) is the "centre" of the universe,
     * (1,1) is one sector up and to the right, and so on.
     */
    public Builder x(Long x) {
      this.x = x;
      return this;
    }

    public Builder y(Long y) {
      this.y = y;
      return this;
    }

    /**
     * number of colonies in this sector
     */
    public Builder num_colonies(Integer num_colonies) {
      this.num_colonies = num_colonies;
      return this;
    }

    /**
     * the collection of stars in this sector.
     */
    public Builder stars(List<Star> stars) {
      Internal.checkElementsNotNull(stars);
      this.stars = stars;
      return this;
    }

    @Override
    public Sector build() {
      return new Sector(x, y, num_colonies, stars, buildUnknownFields());
    }
  }

  private static final class ProtoAdapter_Sector extends ProtoAdapter<Sector> {
    ProtoAdapter_Sector() {
      super(FieldEncoding.LENGTH_DELIMITED, Sector.class);
    }

    @Override
    public int encodedSize(Sector value) {
      return (value.x != null ? ProtoAdapter.INT64.encodedSizeWithTag(1, value.x) : 0)
          + (value.y != null ? ProtoAdapter.INT64.encodedSizeWithTag(2, value.y) : 0)
          + (value.num_colonies != null ? ProtoAdapter.INT32.encodedSizeWithTag(5, value.num_colonies) : 0)
          + Star.ADAPTER.asRepeated().encodedSizeWithTag(3, value.stars)
          + value.unknownFields().size();
    }

    @Override
    public void encode(ProtoWriter writer, Sector value) throws IOException {
      if (value.x != null) ProtoAdapter.INT64.encodeWithTag(writer, 1, value.x);
      if (value.y != null) ProtoAdapter.INT64.encodeWithTag(writer, 2, value.y);
      if (value.num_colonies != null) ProtoAdapter.INT32.encodeWithTag(writer, 5, value.num_colonies);
      if (value.stars != null) Star.ADAPTER.asRepeated().encodeWithTag(writer, 3, value.stars);
      writer.writeBytes(value.unknownFields());
    }

    @Override
    public Sector decode(ProtoReader reader) throws IOException {
      Builder builder = new Builder();
      long token = reader.beginMessage();
      for (int tag; (tag = reader.nextTag()) != -1;) {
        switch (tag) {
          case 1: builder.x(ProtoAdapter.INT64.decode(reader)); break;
          case 2: builder.y(ProtoAdapter.INT64.decode(reader)); break;
          case 5: builder.num_colonies(ProtoAdapter.INT32.decode(reader)); break;
          case 3: builder.stars.add(Star.ADAPTER.decode(reader)); break;
          default: {
            FieldEncoding fieldEncoding = reader.peekFieldEncoding();
            Object value = fieldEncoding.rawProtoAdapter().decode(reader);
            builder.addUnknownField(tag, fieldEncoding, value);
          }
        }
      }
      reader.endMessage(token);
      return builder.build();
    }

    @Override
    public Sector redact(Sector value) {
      Builder builder = value.newBuilder();
      Internal.redactElements(builder.stars, Star.ADAPTER);
      builder.clearUnknownFields();
      return builder.build();
    }
  }
}
