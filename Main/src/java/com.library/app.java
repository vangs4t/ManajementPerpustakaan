package com.library;

import com.cover.View.ViewImpl;
import com.paper.repository.LibraryRepoImpl;
import com.write.service.LibraryServiceImpl;

public class app {
    public static void main(String[] args) {
        LibraryRepoImpl repo = new LibraryRepoImpl();
        LibraryServiceImpl service = new LibraryServiceImpl(repo);
        ViewImpl view = new ViewImpl(service);
        view.mainMenu();
    }
}
