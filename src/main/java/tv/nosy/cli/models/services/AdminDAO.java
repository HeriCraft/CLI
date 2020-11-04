package tv.nosy.cli.models.services;

import java.util.List;

import tv.nosy.cli.models.dao.Admin;

public interface AdminDAO {
    public void update(Admin a);
    public List<Admin> getAllAdmin();
    public void addAdmin(Admin a);
    public Admin getAdmin(long id);
    public void delete(long id);
}
