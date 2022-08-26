//public class News {
//    public static void main(String[] args) {
//
//        NewsApiClient newsApiClient = new NewsApiClient("YOUR_API_KEY");
//
//// /v2/everything
//        newsApiClient.getEverything(
//                new EverythingRequest.Builder()
//                        .q("trump")
//                        .build(),
//                new NewsApiClient.ArticlesResponseCallback() {
//                    @Override
//                    public void onSuccess(ArticleResponse response) {
//                        System.out.println(response.getArticles().get(0).getTitle());
//                    }
//
//                    @Override
//                    public void onFailure(Throwable throwable) {
//                        System.out.println(throwable.getMessage());
//                    }
//                }
//        );
//
//// /v2/top-headlines
//        newsApiClient.getTopHeadlines(
//                new TopHeadlinesRequest.Builder()
//                        .q("bitcoin")
//                        .language("en")
//                        .build(),
//                new NewsApiClient.ArticlesResponseCallback() {
//                    @Override
//                    public void onSuccess(ArticleResponse response) {
//                        System.out.println(response.getArticles().get(0).getTitle());
//                    }
//
//                    @Override
//                    public void onFailure(Throwable throwable) {
//                        System.out.println(throwable.getMessage());
//                    }
//                }
//        );
//    }
//
//
//}
