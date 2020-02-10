package spring.jdbc;

import org.springframework.stereotype.Component;
import spring.model.Member;
import org.springframework.jdbc.core.RowMapper;
import javax.swing.tree.TreePath;
import java.sql.ResultSet;
import java.sql.SQLException;

@Component("memberRowMapper")
public class MemberRowMapper implements RowMapper<Member> {

    @Override
    public Member mapRow(ResultSet resultSet, int rowNum) throws SQLException{
        System.out.println(resultSet.getString(1));
        Member member = new Member(resultSet.getString(1),resultSet.getString(2));
        return member;
    }
}
