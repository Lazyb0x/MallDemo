package cn.beanbang.malldemo.service;


public interface ICartService {
    boolean add(Long goodId);

    boolean add(Long goodId, int num);

    Object list();

    boolean remove(Long goodId);

    long settle();
}
