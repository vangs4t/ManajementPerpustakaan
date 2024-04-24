package com.write.service;

import com.paper.repository.LibraryRepoImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
@ExtendWith(MockitoExtension.class)
public class LibraryServiceImplTest {
    @Mock
    public LibraryRepoImpl libraryRepo;

    LibraryServiceImpl libraryService;
    void anjay(){

    }

    @BeforeEach
    static void setUp() {
        LibraryServiceImpl service = new LibraryServiceImpl(new LibraryRepoImpl());
    }

    @Test
    void get() {

    }
}
