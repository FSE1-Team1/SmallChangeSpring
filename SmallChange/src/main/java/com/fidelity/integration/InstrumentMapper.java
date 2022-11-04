package com.fidelity.integration;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.mapping.StatementType;

import com.fidelity.model.Instrument;

public interface InstrumentMapper {

	@Select("""
			SELECT "instrument_id","instrument_description","external_id","external_id_type","min_quantity","max_quantity","category_id" FROM SC_Instrument
			""")
	@Results({
		@Result(property="instrumentId", column="instrument_id", id=true),
		@Result(property="instrumentDescription", column="instrument_description"),
		@Result(property="externalId", column="external_id"),
		@Result(property="externalIdType", column="external_id_type"),
		@Result(property="minQuantity", column="min_quantity"),
		@Result(property="maxQuantity", column="max_quantity"),
		@Result(property="categoryId", column="category_id"),
		@Result(property="price", column="instrument_id",
		one = @One(select="com.fidelity.integration.PriceMapper.queryPrice"))
		})
	List<Instrument> queryAllInstruments();

	@Select("""
			SELECT "instrument_id","instrument_description","external_id","external_id_type","min_quantity","max_quantity","category_id" FROM SC_Instrument WHERE "instrument_id"=#{instrumentId}
			""")
	@Results({
		@Result(property="instrumentId", column="instrument_id", id=true),
		@Result(property="instrumentDescription", column="instrument_description"),
		@Result(property="externalId", column="external_id"),
		@Result(property="externalIdType", column="external_id_type"),
		@Result(property="minQuantity", column="min_quantity"),
		@Result(property="maxQuantity", column="max_quantity"),
		@Result(property="categoryId", column="category_id"),
		@Result(property="price", column="instrument_id",
		one = @One(select="com.fidelity.integration.PriceMapper.queryPrice"))
		})
	Instrument queryInstrumentsById(String instrumentId);

	@Insert("""
			INSERT INTO SC_INSTRUMENT("instrument_id","instrument_description","external_id","external_id_type","min_quantity","max_quantity","category_id") VALUES (#{instrumentId},#{instrumentDescription},#{externalId},#{externalIdType},#{minQuantity},#{maxQuantity},#{categoryId})
			""")
	int insertInstrument(Instrument instrument);

	@Update("""
			UPDATE SC_INSTRUMENT SET "instrument_description"=#{instrumentDescription},"external_id"=#{externalId},"external_id_type"=#{externalIdType},"min_quantity"=#{minQuantity},"max_quantity"=#{maxQuantity},"category_id"=#{categoryId} WHERE "instrument_id"=#{instrumentId}
			""")
	int updateInstrument(Instrument instrument);

	@Delete("{ CALL proc_delete_instrument_delete_holding(#{instrDelete, mode=IN, jdbcType=VARCHAR}) }")
	@Options(statementType = StatementType.CALLABLE)
	void deleteInstrument(@Param("instrDelete") String instrumentId);

}
