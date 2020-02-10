package spring.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.stereotype.Service;
import spring.model.Member;

import javax.inject.Inject;
import java.util.HashMap;
import java.util.List;

@Service("memberDAO")
public class MemberServiceImp implements MemberDao {

    private static final String FIND_ALL_SQL = "SELECT imie, nazwisko FROM dziekanat.studenci";

    @Autowired
    @Qualifier("jdbcTemplate")
    private NamedParameterJdbcOperations jdbcTemplate;
    @Autowired
    @Qualifier("memberRowMapper")
    private MemberRowMapper memberRowMapper;

    @Override
    public List<Member> findAll() throws Exception {
        return jdbcTemplate.query(FIND_ALL_SQL, new HashMap<String, Object>(), memberRowMapper);
    }
}
