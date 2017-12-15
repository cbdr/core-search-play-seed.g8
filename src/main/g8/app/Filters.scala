import javax.inject.Inject

import filters.LoggingFilter
import play.filters.gzip.GzipFilter
import play.http.DefaultHttpFilters

class Filters @Inject()(
                         gzip: GzipFilter,
                         log: LoggingFilter
                       ) extends DefaultHttpFilters(log, gzip)