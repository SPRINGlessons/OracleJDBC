package com.dimitrisli.springJdbcOracle.dao.impl;

import com.dimitrisli.springJdbcOracle.dao.LocationDao;
import com.dimitrisli.springJdbcOracle.orm.LocationRowMapper;
import javax.sql.DataSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.stereotype.Repository;
import javax.inject.Inject;
import java.util.HashMap;
import java.util.List;

@Repository("locationDao")
public class LocationDaoImpl implements LocationDao {


    private static final String GET_ALL_SQL = "SELECT 1 FROM DUAL";
    private static final String TEST_SQL = "select ws.calcid,  ws.targetcompany from ws_calc_logs_new ws where calcid = 169187175";


    @Inject private NamedParameterJdbcOperations jdbcTemplate;
    private DataSource dataSource;
    @Inject private LocationRowMapper locationRowMapper;



    @Override
    public List<String> getLocations() {
        return jdbcTemplate.query(TEST_SQL, new HashMap<String, Object>(), locationRowMapper);
    }



}
