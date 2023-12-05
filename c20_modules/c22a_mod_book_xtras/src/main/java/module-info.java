import de.book.xtras.run.LoadAndReportBooksRunnable;
import de.book.xtras.run.ShowRandomIsbnRunnable;

module mod.book.xtras {
    provides java.lang.Runnable
            with LoadAndReportBooksRunnable,
                    ShowRandomIsbnRunnable;

}