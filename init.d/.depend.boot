TARGETS = console-setup resolvconf mountkernfs.sh hostname.sh udev networking hwclock.sh urandom mountdevsubfs.sh checkroot.sh checkroot-bootclean.sh bootmisc.sh mountnfs-bootclean.sh mountnfs.sh mountall.sh checkfs.sh procps mountall-bootclean.sh kmod
INTERACTIVE = console-setup udev checkroot.sh checkfs.sh
udev: mountkernfs.sh
networking: resolvconf mountkernfs.sh urandom procps
hwclock.sh: mountdevsubfs.sh
urandom: hwclock.sh
mountdevsubfs.sh: mountkernfs.sh udev
checkroot.sh: hwclock.sh mountdevsubfs.sh hostname.sh
checkroot-bootclean.sh: checkroot.sh
bootmisc.sh: checkroot-bootclean.sh mountnfs-bootclean.sh udev mountall-bootclean.sh
mountnfs-bootclean.sh: mountnfs.sh
mountnfs.sh: networking
mountall.sh: checkfs.sh checkroot-bootclean.sh
checkfs.sh: checkroot.sh
procps: mountkernfs.sh udev
mountall-bootclean.sh: mountall.sh
kmod: checkroot.sh
