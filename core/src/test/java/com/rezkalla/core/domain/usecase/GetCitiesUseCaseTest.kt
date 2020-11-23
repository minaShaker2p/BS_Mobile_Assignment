package com.rezkalla.core.domain.usecase

import com.rezkalla.core.domain.repository.CitiesRepository
import com.rezkalla.core.domain.utils.TestDataGenerator
import junit.framework.Assert.assertEquals
import junit.framework.Assert.assertTrue
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

@RunWith(JUnit4::class)
class GetCitiesUseCaseTest {

    @Mock
    private lateinit var repository: CitiesRepository

    private lateinit var useCase: GetCitiesUseCase

    @Before
    fun setup() {
        MockitoAnnotations.initMocks(this)
        useCase = GetCitiesUseCase(repository)
    }


    @Test
    fun `test get all cities return list of cities successfully`() {
        // when
        val cities = TestDataGenerator.getTestData()
        Mockito.`when`(repository.getCities())
            .thenReturn(cities)

        // action
        val results = useCase()

        // verify
        assertEquals(cities, results)
        assertTrue(results.isNotEmpty())
        assertEquals(cities.size, results.size)
        assertEquals(results[0],cities[0])

    }


    @Test
    fun `test get all cities return empty list successfully`() {
        // when
        Mockito.`when`(repository.getCities())
            .thenReturn(emptyList())

        // action
        val results = useCase()

        // verify
        assertTrue(results.isEmpty())

    }

}