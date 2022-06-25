package com.example.springdemo.BeanDefinitionRegistry.Model;

public class RepoContext {

    DataSource dataSource;
    SearchClient searchClient;

    public RepoContext(DataSource dataSource, SearchClient searchClient) {
        this.dataSource = dataSource;
        this.searchClient = searchClient;
    }

    public DataSource getDataSource() {
        return dataSource;
    }

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public SearchClient getSearchClient() {
        return searchClient;
    }

    public void setSearchClient(SearchClient searchClient) {
        this.searchClient = searchClient;
    }
}
