package com.atc.domains.home;

import com.atc.domains.home.entity.Task;

import java.util.List;

/**
 * Created by Viki.Feng on 01/02/2016.
 */
public interface ITaskDAO {
    List<Task> selectTasks();
}
