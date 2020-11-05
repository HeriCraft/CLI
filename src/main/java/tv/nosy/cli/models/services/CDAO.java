package tv.nosy.cli.models.services;

import tv.nosy.cli.models.dao.Cd;

public interface CDAO {
    public Cd getCode(long ref);
    public void addCode(Cd c);
    public void update(Cd c);
    public void remove(Cd c);
}
